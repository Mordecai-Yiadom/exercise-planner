package com.projectname.app.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
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
        GridLayout layout = new GridLayout(7, 1, 0, 10);
        CONTENT_PANE.setLayout(layout);
        setViewportView(CONTENT_PANE);
    }

    private void initComponents()
    {

    }

    private JLabel createNoPlanLabel()
    {
        JLabel label = new JLabel();
        label.setBackground(Toolbar.BACKGROUND_COLOR);
        label.setForeground(Color.LIGHT_GRAY);
        label.setText("Nothing planned for this day.");
        return label;
    }

    private JButton createAddButton()
    {
        JButton button = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_ADD_BUTTON,
                "add.png", null);
        button.addActionListener(new AddWorkoutPlanListener(DayOfWeek.MONDAY));
        return button;
    }

    private JButton createRemoveButton()
    {
        return null;
    }

    private static class AddWorkoutPlanListener implements ActionListener
    {
        private DayOfWeek day;

        private AddWorkoutPlanListener(DayOfWeek day) {this.day = day;}

        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
