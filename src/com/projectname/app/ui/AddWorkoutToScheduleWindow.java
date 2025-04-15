package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.Schedule;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AddWorkoutToScheduleWindow extends JDialog
{
    private JComboBox HOUR_COMBO, MINUTE_COMBO, AM_PM_COMBO, WORKOUT_PLAN_COMBO;
    private DayOfWeek day;
    protected AddWorkoutToScheduleWindow(DayOfWeek day)
    {
        super(AppUIManager.window(), "Schedule Workout for " + day);
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

        if(localDatabase.getWorkoutPlans().isEmpty())
        {
            getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
            getContentPane().add(createLabel("No Workout Plans Available."));

            //Confirm/Cancel Buttons
            JPanel buttonPanel = createBackPanel(new FlowLayout(FlowLayout.CENTER),
                    new ButtonFactory().createTextButton(ButtonFactory.GenericType.DATABASE_CANCEL_CREATION_BUTTON,
                            "CANCEL", (e)->{dispose();}));
            getContentPane().add(buttonPanel);
            return;
        }

        //Select Workout Label + Combo
        WORKOUT_PLAN_COMBO = createComboBox(localDatabase.getWorkoutPlans().toArray(new WorkoutPlan[0]));
        JPanel selectWorkoutPlanPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT),
                createLabel("Workout Plan: "), WORKOUT_PLAN_COMBO);
        getContentPane().add(selectWorkoutPlanPanel);

        //Time Label Combos
        Integer timeHourArray[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        String timeMinuteArray[] = {"00", "05", "10", "15", "25", "30", "35", "40", "45", "50", "55"};
        String timeAmPmArray[] = {"AM", "PM"};
        HOUR_COMBO = createComboBox(timeHourArray);
        MINUTE_COMBO = createComboBox(timeMinuteArray);
        AM_PM_COMBO = createComboBox(timeAmPmArray);

        JPanel timePanel = createBackPanel(new FlowLayout(FlowLayout.LEFT),
                createLabel("Time: "), HOUR_COMBO, MINUTE_COMBO, AM_PM_COMBO);
        getContentPane().add(timePanel);

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
            Schedule schedule = Application.instance().getUserSchedule();
            schedule.scheduleWorkoutPlan(window.day, parseLocalTime(),
                    (WorkoutPlan) window.WORKOUT_PLAN_COMBO.getSelectedItem());
            window.dispose();
            AppUIManager.window().displayMenu(new EditWorkoutSchedule());
        }

        private LocalTime parseLocalTime()
        {
            int hour = (Integer) window.HOUR_COMBO.getSelectedItem();
            int minute = (Integer.parseInt((String)window.MINUTE_COMBO.getSelectedItem()));
            boolean isPM = ((String) window.AM_PM_COMBO.getSelectedItem()).equalsIgnoreCase("PM");

            if(isPM) hour += 12;
            else if(hour == 12) hour = 0;

            return LocalTime.of(hour, minute, 0);
        }
    }
}
