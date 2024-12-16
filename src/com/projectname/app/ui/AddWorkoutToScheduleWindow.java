package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

public class AddWorkoutToScheduleWindow extends JDialog
{
    private JComboBox HOUR_COMBO, MINUTE_COMBO, WORKOUT_PLAN_COMBO;
    private DayOfWeek day;
    protected AddWorkoutToScheduleWindow(DayOfWeek day)
    {
        super(AppUIManager.window(), "Create New Exercise");
        init();
        initComponents();
        setVisible(true);
        this.day = day;
    }

    private void init()
    {
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(4,1));
    }

    private void initComponents()
    {
        LocalDatabase localDatabase = Application.instance().getLocalDatabase();

        //Select Workout Label + Combo
        JPanel selectWorkoutPlanPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT),
                createLabel("Workout Plan: "),
                createComboBox(localDatabase.getWorkoutPlans().toArray(new WorkoutPlan[0])));
        getContentPane().add(selectWorkoutPlanPanel);

        //Confirm/Cancel Buttons
        JPanel buttonPanel = createBackPanel(new FlowLayout(FlowLayout.CENTER), new ButtonFactory()
                        .createTextButton(ButtonFactory.GenericType.DATABASE_CONFIRM_CREATION_BUTTON, "CONFIRM",
                                new AddWorkoutToScheduleWindow.ConfirmScheduleListener(this)),
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
        comboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        comboBox.setFocusable(true);
        return comboBox;
    }

    private static class ConfirmScheduleListener implements ActionListener
    {
        private AddWorkoutToScheduleWindow window;

        protected ConfirmScheduleListener(AddWorkoutToScheduleWindow window) {this.window = window;}

        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
