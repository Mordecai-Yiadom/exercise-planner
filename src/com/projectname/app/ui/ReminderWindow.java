package com.projectname.app.ui;

import com.projectname.app.AppReminder;
import com.projectname.app.Application;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ReminderWindow extends JFrame
{
    protected ReminderWindow()
    {
        init();
        initComponents();
    }

    protected ReminderWindow(AppReminder reminder)
    {
        this();
    }

    private void init()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        getContentPane().setLayout(new GridLayout(2,1));
        setResizable(false);
        setTitle("Workout Reminder");
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500,200);

        try
        {
            URL imageURL = AppUIManager.class.getResource(AppUIManager.APP_ICON);
            setIconImage(new ImageIcon(imageURL).getImage());
        }
        catch(Exception ex) {ex.printStackTrace();}
    }

    private void initComponents()
    {
        JLabel reminderLabel = new JLabel("It's Time to Workout!");
        reminderLabel.setFont(new Font(AppUIManager.FONT, Font.BOLD, 25));
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
        button.addActionListener((e)->{
            Application.wake();
            this.dispose();
        });
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
