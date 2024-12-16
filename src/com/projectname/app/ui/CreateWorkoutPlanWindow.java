package com.projectname.app.ui;

import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWorkoutPlanWindow extends JDialog
{
    private WorkoutPlan workoutPlan;
    private JTextField NAME_TEXT_FIELD, NUM_OF_SETS_FIELD;

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

        }
    }
}
