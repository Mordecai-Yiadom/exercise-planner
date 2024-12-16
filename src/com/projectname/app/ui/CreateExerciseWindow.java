package com.projectname.app.ui;

import com.projectname.app.exercise.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateExerciseWindow extends JDialog
{
    private Exercise exercise;

    private ButtonGroup intesityButtonGroup;
    private ButtonGroup infoButtonGroup;

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
        exercise = new Exercise();
        getContentPane().setLayout(new GridLayout(3,1));
        intesityButtonGroup = new ButtonGroup();
        infoButtonGroup = new ButtonGroup();

        JPanel namePanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Name: "), createTextField());
        getContentPane().add(namePanel);

        JPanel intensityPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Intensity: "),
                createRadioButton("Low", intesityButtonGroup, (e)->{exercise.setIntensity(Exercise.Intensity.LOW);}),
                createRadioButton("Medium", intesityButtonGroup, (e)->{exercise.setIntensity(Exercise.Intensity.MEDIUM);}),
                createRadioButton("High", intesityButtonGroup, (e)->{exercise.setIntensity(Exercise.Intensity.LOW);}));
        getContentPane().add(intensityPanel);

        JPanel infoPanel = createBackPanel(new FlowLayout(FlowLayout.LEFT), createLabel("Info: "),
                createRadioButton("Reps", infoButtonGroup, null),
                createRadioButton("Distance", infoButtonGroup, null),
                createRadioButton("Duration", infoButtonGroup, null));
        getContentPane().add(infoPanel);
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

    private JRadioButton createRadioButton(String text, ButtonGroup group, ActionListener actionListener)
    {
        JRadioButton button = new JRadioButton(text);
        button.setBackground(Toolbar.BACKGROUND_COLOR);
        button.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.addActionListener(actionListener);
        button.setUI(new BasicRadioButtonUI());
        button.setFocusable(false);
        if(group != null) group.add(button);

        return button;
    }
}
