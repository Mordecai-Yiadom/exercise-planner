package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.Schedule;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.awt.desktop.AppForegroundListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

public class EditWorkoutSchedule extends JScrollPane implements AppMenu
{
    private JPanel CONTENT_PANE;

    protected EditWorkoutSchedule()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setUI(new BasicScrollPaneUI());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        CONTENT_PANE = new JPanel();
        CONTENT_PANE.setBackground(Toolbar.BACKGROUND_COLOR);
        GridLayout layout = new GridLayout(9, 1, 0, 0);
        CONTENT_PANE.setLayout(layout);
        setViewportView(CONTENT_PANE);
    }

    private void initComponents()
    {
        Schedule schedule = Application.instance().getUserSchedule();

        for(DayOfWeek day : DayOfWeek.class.getEnumConstants())
        {
            WorkoutPlan workoutPlan = schedule.getWorkoutPlan(day);

            if(workoutPlan == null)
            {
                JPanel backPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel(day.name()),
                        createAddButton(day));
                backPanel.setBorder(BorderFactory.createLineBorder(Toolbar.BACKGROUND_COLOR, 10));
                CONTENT_PANE.add(backPanel);
            }
            else
            {
                JLabel nameLabel = createLabel(workoutPlan.getName());
                nameLabel.setForeground(Color.WHITE);

                String dayTimeText = String.format("%s (%s): ", day.name(), schedule.getScheduledTime(day).toString());
                JPanel backPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT),createLabel(dayTimeText),
                        nameLabel, createRemoveButton(day));
                backPanel.setBorder(BorderFactory.createLineBorder(Toolbar.BACKGROUND_COLOR, 10));
                CONTENT_PANE.add(backPanel);
            }
        }
    }

    private JPanel createBackPanel(LayoutManager layout, Component... components)
    {
        JPanel panel = new JPanel(layout);
        panel.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        for(Component c : components) panel.add(c);
        return panel;
    }

    private JLabel createLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setBackground(Toolbar.BACKGROUND_COLOR);
        label.setForeground(Color.LIGHT_GRAY);
        label.setFont(new Font(AppUIManager.FONT, Font.BOLD, 30));
        return label;
    }

    private JButton createAddButton(DayOfWeek day)
    {
        JButton button = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_ADD_BUTTON,
                "add-30x30.png", null);
        button.setSize(30,30);
        button.addActionListener((e)->{new AddWorkoutToScheduleWindow(day);});
        return button;
    }

    private JButton createRemoveButton(DayOfWeek day)
    {
        JButton button = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_REMOVE_BUTTON,
                "cross-circle-30x30.png", null);
        button.setSize(30,30);
        button.addActionListener(new RemoveButtonListener(day));
        return button;
    }

    private static class RemoveButtonListener implements ActionListener
    {
        private DayOfWeek day;
        private RemoveButtonListener(DayOfWeek day) {this.day = day;}

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Schedule schedule = Application.instance().getUserSchedule();
            schedule.scheduleWorkoutPlan(this.day, null, null);
            AppUIManager.window().displayMenu(new EditWorkoutSchedule());
            System.out.println("Removed");
        }
    }
}
