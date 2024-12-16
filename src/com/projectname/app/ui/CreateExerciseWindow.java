package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class CreateExerciseWindow extends JDialog
{
    protected CreateExerciseWindow()
    {
        super(AppUIManager.window(), "Create New Exercise");

        init();
        initComponents();
        setVisible(true);
    }

    private void init()
    {
        getContentPane().setBackground(Toolbar.BACKGROUND_COLOR);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents()
    {
        getContentPane().setLayout(new GridLayout(3,1));

        JPanel namePanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Name: "), createTextField());
        getContentPane().add(namePanel);

    }


    private JTextField createTextField()
    {
        JTextField textField = new JTextField();
        textField.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        textField.setSize(100,50);
        textField.setPreferredSize(new Dimension(200,25));
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
}
