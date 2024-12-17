package com.projectname.app.ui;

import com.projectname.app.AppReminder;
import com.projectname.app.Application;

import javax.swing.*;
import java.awt.*;

public class MinimizedWindow extends JFrame
{
    protected MinimizedWindow()
    {
        init();
        initComponents();
    }


    private void init()
    {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        setResizable(false);
        setTitle("Exercise Planner");
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,100);
    }

    private void initComponents()
    {
        getContentPane().add(createBackPanel(new FlowLayout(FlowLayout.CENTER),
                createOpenAppButton(), createCloseAppButton()));
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

    private JButton createCloseAppButton()
    {
        JButton button = new ButtonFactory().createTextButton(ButtonFactory.GenericType.DATABASE_CANCEL_CREATION_BUTTON,
                "QUIT");
        button.addActionListener((e)->{
            Application.terminate();});
        return button;
    }
}
