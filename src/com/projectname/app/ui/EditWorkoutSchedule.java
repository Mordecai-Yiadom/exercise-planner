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
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        CONTENT_PANE = new JPanel();
        CONTENT_PANE.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        GridLayout layout = new GridLayout(9, 1, 0, 10);
        CONTENT_PANE.setLayout(layout);
        setViewportView(CONTENT_PANE);
    }

    private void initComponents()
    {
        Schedule schedule = Application.instance().getUserSchedule();

        for(DayOfWeek day : DayOfWeek.class.getEnumConstants())
        {
            WorkoutPlan workoutPlan = schedule.getWorkoutPlan(day);

            if(workoutPlan == null) CONTENT_PANE.add(createBackPanel(new FlowLayout(FlowLayout.CENTER),
                    createLabel(day.name()), createAddButton(day)));
            else
            {
                JLabel nameLabel = createLabel(workoutPlan.getName());
                nameLabel.setForeground(Color.WHITE);

                String dayTimeText = String.format("%s (%s): ", day.name(), schedule.getScheduledTime(day).toString());
                JPanel backPanel = createBackPanel(new FlowLayout(FlowLayout.CENTER),createLabel(dayTimeText),
                        nameLabel);
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

    private JButton createRemoveButton()
    {
        return null;
    }
}
