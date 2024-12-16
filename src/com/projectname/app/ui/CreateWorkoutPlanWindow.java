package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.Exercise;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWorkoutPlanWindow extends JDialog
{
    private WorkoutPlan workoutPlan;
    private JTextField NAME_TEXT_FIELD, NUM_OF_SETS_FIELD;
    private JScrollPane EXERCISES_SCROLL_PANE;

    protected CreateWorkoutPlanWindow()
    {
        super(AppUIManager.window(), "Create New Workout Plan");
        init();
        initComponents();
        setVisible(true);
    }

    private void init()
    {
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        setSize(900,500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents()
    {
        workoutPlan = new WorkoutPlan();
        getContentPane().setLayout(new GridLayout(4,1));

        //WorkoutPlan Name
        NAME_TEXT_FIELD = createTextField();
        JPanel namePanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Name: "), NAME_TEXT_FIELD);
        getContentPane().add(namePanel);

        //WorkoutPlan sets
        NUM_OF_SETS_FIELD = createTextField();
        JPanel setsPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Sets: "), NUM_OF_SETS_FIELD);
        getContentPane().add(setsPanel);

        //JPanel exercisesPanel = createBackPanel(new FlowLayout(FlowLayout.CENTER), createScrollPane());
        getContentPane().add(createScrollPane());

        //Confirm/Cancel Buttons
        JPanel buttonPanel = createBackPanel(new FlowLayout(FlowLayout.CENTER), new ButtonFactory()
                        .createTextButton(ButtonFactory.GenericType.DATABASE_CONFIRM_CREATION_BUTTON, "CONFIRM",
                                new CreateWorkoutPlanWindow.CreationListener(this)),
                new ButtonFactory()
                        .createTextButton(ButtonFactory.GenericType.DATABASE_CANCEL_CREATION_BUTTON, "CANCEL",
                                (e)->{dispose();}));
        getContentPane().add(buttonPanel);
    }

    private JTextField createTextField(int width)
    {
        JTextField textField = createTextField();
        textField.setSize(width, textField.getHeight());
        return textField;
    }

    private JScrollPane createScrollPane()
    {
        LocalDatabase database = Application.instance().getLocalDatabase();
        JPanel rootPane = new JPanel(new GridLayout(database.getExercises().size(), 1));
        rootPane.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);

        for(Exercise exercise : database.getExercises())
        {
            WorkoutPlanEntryUI workoutPlanEntryUI = new WorkoutPlanEntryUI(exercise);
            JPanel buttonPanel = createBackPanel(new FlowLayout(FlowLayout.RIGHT), createSelectButton(workoutPlanEntryUI));
            JPanel panel = createBackPanel(new FlowLayout(FlowLayout.LEFT), workoutPlanEntryUI, buttonPanel);
            rootPane.add(panel);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(rootPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setUI(new BasicScrollPaneUI());
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        scrollPane.setSize(new Dimension(200,500));

        return scrollPane;
    }

    private JToggleButton createSelectButton(WorkoutPlanEntryUI entryUI)
    {
        JToggleButton button = new JToggleButton();
        button.setUI(new BasicButtonUI());
        button.setForeground(Color.WHITE);
        button.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        button.setFocusable(false);
        button.setSize(50,50);
        button.addActionListener(new SelectButtonListener(this, entryUI));

        button.setSelected(false);
        button.setText("Unselected");
        button.setBackground(new Color(204, 24, 24));

        button.setBorderPainted(false);

        return button;
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
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        textField.setUI(new BasicTextFieldUI());
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

    private static class CreationListener implements ActionListener
    {
        private CreateWorkoutPlanWindow window;
        private CreationListener(CreateWorkoutPlanWindow window) {this.window = window;}

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(window.NAME_TEXT_FIELD.getText().isEmpty() || window.NUM_OF_SETS_FIELD.getText().isEmpty())
            {
                window.createMessageWindow("Error", "More Input is Needed");
                return;
            }

            if(window.workoutPlan.getExercises().size() <= 0)
            {
                window.createMessageWindow("Error", "Select at least 1 Exercise");
                return;
            }

            try {window.workoutPlan.setNumOfSets((int)Double.parseDouble(window.NUM_OF_SETS_FIELD.getText()));}
            catch(Exception exception)
            {
                window.createMessageWindow("Error", "Invalid Input for Sets");
                return;
            }

            window.workoutPlan.setName(window.NAME_TEXT_FIELD.getText());

            Application.instance().getLocalDatabase().addWorkoutPlan(window.workoutPlan);
            window.dispose();
        }
    }

    private static class SelectButtonListener implements ActionListener
    {
        private CreateWorkoutPlanWindow window;
        private WorkoutPlanEntryUI workoutPlanEntryUI;

        private SelectButtonListener(CreateWorkoutPlanWindow window, WorkoutPlanEntryUI workoutPlanEntryUI)
        {
            this.window = window;
            this.workoutPlanEntryUI = workoutPlanEntryUI;
        }

        @Override
        public void actionPerformed(ActionEvent event)
        {
            JToggleButton button = (JToggleButton) event.getSource();
            if(button.isSelected())
            {
                window.workoutPlan.addExercise(workoutPlanEntryUI.getExercise());
                button.setBackground(new Color(42, 158, 6));
                button.setText("Selected");
            }
            else
            {
                window.workoutPlan.removeExercise(workoutPlanEntryUI.getExercise());
                button.setBackground(new Color(204, 24, 24));
                button.setText("Unselected");
            }
        }
    }
}
