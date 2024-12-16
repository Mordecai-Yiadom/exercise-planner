package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class CreateExerciseWindow extends JDialog
{
    private Exercise exercise;
    private JTextField NAME_TEXT_FIELD, INFO_TEXT_FIELD;
    private JComboBox EXERCISE_TYPE_COMBO;

    private ButtonGroup intesityButtonGroup;
    private ButtonGroup infoButtonGroup;

    protected CreateExerciseWindow()
    {
        super(AppUIManager.window(), "Create New Exercise");
        init();
        initComponents();
        setVisible(true);
    }

    private void init()
    {
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents()
    {
        exercise = new Exercise();
        getContentPane().setLayout(new GridLayout(5,1, 5, 0));
        intesityButtonGroup = new ButtonGroup();
        infoButtonGroup = new ButtonGroup();

        //Exercise Name
        NAME_TEXT_FIELD = createTextField();
        JPanel namePanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Name: "), NAME_TEXT_FIELD);
        getContentPane().add(namePanel);

        //Exercise Type
        LocalDatabase database = Application.instance().getLocalDatabase();
        EXERCISE_TYPE_COMBO = createComboBox(database.getExerciseTypes().toArray(new ExerciseType[0]));
        JPanel exerciseTypePanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Type: "),
                EXERCISE_TYPE_COMBO);
        getContentPane().add(exerciseTypePanel);

        //Exercise Intensity
        JPanel intensityPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Intensity: "),
                createRadioButton("Low", intesityButtonGroup, (e)->{exercise.setIntensity(Exercise.Intensity.LOW);}),
                createRadioButton("Medium", intesityButtonGroup, (e)->{exercise.setIntensity(Exercise.Intensity.MEDIUM);}),
                createRadioButton("High", intesityButtonGroup, (e)->{exercise.setIntensity(Exercise.Intensity.HIGH);}));
        getContentPane().add(intensityPanel);

        //Exercise Reps/Duration/Distance
        INFO_TEXT_FIELD = createTextField(50);
        JPanel infoPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Info: "),
                createRadioButton("Reps", infoButtonGroup, null),
                createRadioButton("Distance", infoButtonGroup, null),
                createRadioButton("Duration", infoButtonGroup, null),
                INFO_TEXT_FIELD);
        getContentPane().add(infoPanel);

        //Confirm/Cancel Buttons
        JPanel buttonPanel = createBackPanel(new FlowLayout(FlowLayout.CENTER), new ButtonFactory()
                        .createTextButton(ButtonFactory.GenericType.DATABASE_CONFIRM_CREATION_BUTTON, "CONFIRM",
                                new CreationListener(this)),
                new ButtonFactory()
                        .createTextButton(ButtonFactory.GenericType.DATABASE_CANCEL_CREATION_BUTTON, "CANCEL",
                                (e)->{dispose();}));
        getContentPane().add(buttonPanel);
    }

    private JTextField createTextField()
    {
        JTextField textField = new JTextField();
        textField.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        textField.setSize(100,50);
        textField.setPreferredSize(new Dimension(200,35));
        textField.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        textField.setUI(new BasicTextFieldUI());
        return textField;
    }

    private JTextField createTextField(int width)
    {
        JTextField textField = createTextField();
        textField.setSize(width, textField.getHeight());
        return textField;
    }

    private JPanel createBackPanel(LayoutManager layoutManager, Component... components)
    {
        JPanel panel = new JPanel(layoutManager);
        for(Component c : components) panel.add(c);
        panel.setBackground(Toolbar.BACKGROUND_COLOR);
        return panel;
    }

    private JLabel createLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        return label;
    }

    private JRadioButton createRadioButton(String text, ButtonGroup group, ActionListener actionListener)
    {
        JRadioButton button = new JRadioButton(text);
        button.setBackground(Toolbar.BACKGROUND_COLOR);
        button.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.addActionListener(actionListener);
        button.setUI(new BasicRadioButtonUI());
        button.setBorderPainted(false);
        button.setFocusable(false);
        if(group != null) group.add(button);

        return button;
    }

    private void createMessageWindow(String title, String message)
    {
        JDialog dialog = new JDialog(this, title);
        dialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        dialog.getContentPane().setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        dialog.getContentPane().setForeground(Color.WHITE);
        dialog.getContentPane().add(AppUIManager.createTestLabel(message, 20));
        dialog.setFont(new Font(AppUIManager.FONT, Font.BOLD, 30));
        dialog.setSize(500,75);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    private JComboBox createComboBox(Object[] items)
    {
        JComboBox comboBox = new JComboBox(items);
        comboBox.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        return comboBox;
    }

    private static class CreationListener implements ActionListener
    {
        private CreateExerciseWindow window;
        private CreationListener(CreateExerciseWindow window) {this.window = window;}

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(window.infoButtonGroup.getSelection() == null || window.intesityButtonGroup.getSelection() == null)
            {
                window.createMessageWindow("Error", "Please Select all Fields");
                return;
            }

            if(window.NAME_TEXT_FIELD.getText().isEmpty() || window.INFO_TEXT_FIELD.getText().isEmpty())
            {
                window.createMessageWindow("Error", "More Input is Needed");
                return;
            }

            //Set Exercise
            int infoButtonIndex = 0;
            for(Enumeration<AbstractButton> e = window.infoButtonGroup.getElements(); e.hasMoreElements();)
            {
                if(e.nextElement().isSelected())
                {
                    try {
                        switch (infoButtonIndex) {
                            case 0:
                                window.exercise.setNumOfReps((int)Double.parseDouble(window.INFO_TEXT_FIELD.getText()));
                                break;
                            case 1:
                                window.exercise.setDistance((float)Double.parseDouble(window.INFO_TEXT_FIELD.getText()));
                                break;
                            case 2:
                                window.exercise.setDuration((long)Double.parseDouble(window.INFO_TEXT_FIELD.getText()));
                                break;
                        }
                        break;
                    }
                    catch(Exception exception)
                    {
                        window.createMessageWindow("Error", "Please Enter Numbers!");
                        return;
                    }
                }
                infoButtonIndex++;
            }

            //Set Exercise Name
            if(window.NAME_TEXT_FIELD.getText() == null) window.exercise.setName("MyWorkoutPlan");
            else if(window.NAME_TEXT_FIELD.getText().isEmpty()) window.exercise.setName("MyWorkoutPlan");
            else window.exercise.setName(window.NAME_TEXT_FIELD.getText());

            window.exercise.setType((ExerciseType) window.EXERCISE_TYPE_COMBO.getSelectedItem());

            //Add exercise to LocalDatabase
            Application.instance().getLocalDatabase().addExercise(window.exercise);
            window.dispose();
            AppUIManager.window().displayMenu(new DatabaseEditExerciseMenu());
        }
    }
}
