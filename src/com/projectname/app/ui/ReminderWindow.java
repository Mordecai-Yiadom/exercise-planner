package com.projectname.app.ui;

import com.projectname.app.Application;

import javax.swing.*;
import java.awt.*;

public class ReminderWindow extends JFrame
{
    protected ReminderWindow()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        getContentPane().setLayout(new GridLayout(2,1));
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents()
    {
        JLabel reminderLabel = new JLabel("It's Time to Workout!");
        reminderLabel.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        reminderLabel.setBackground(Toolbar.BACKGROUND_COLOR);
        reminderLabel.setForeground(Color.WHITE);

        getContentPane().add(createBackPanel(new FlowLayout(FlowLayout.CENTER), reminderLabel));

        getContentPane().add(createBackPanel(new FlowLayout(FlowLayout.CENTER),
                createOpenAppButton(), createIgnoreAppButton()));
    }

    private JPanel createBackPanel(LayoutManager layoutManager, Component... components)
    {
        JPanel panel = new JPanel(layoutManager);
        panel.setBackground(Toolbar.BACKGROUND_COLOR);
        panel.setForeground(Color.WHITE);

        for(Component c : components) panel.add(c);
        return panel;
    }

    private JButton createOpenAppButton()
    {
        JButton button = new ButtonFactory().createTextButton(ButtonFactory.GenericType.DATABASE_CONFIRM_CREATION_BUTTON,
                "OPEN APP");
        button.addActionListener((e)->{Application.wake();});
        return button;
    }

    private JButton createIgnoreAppButton()
    {
        JButton button = new ButtonFactory().createTextButton(ButtonFactory.GenericType.DATABASE_CANCEL_CREATION_BUTTON,
                "IGNORE");
        button.addActionListener((e)->{this.dispose();});
        return button;
    }
}