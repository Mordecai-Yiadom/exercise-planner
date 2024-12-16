package com.projectname.app.ui;

import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import java.awt.*;

public class HomeMenu extends JPanel implements AppMenu
{
    //Instance Variables
    private JButton FORWARD_BUTTON, BACKWARD_BUTTON;
    private WorkoutPlanUI WORKOUT_PLAN_UI;
    private JPanel CENTER_ROOT_PANE;
    private JLabel SETS_LABEL;
    private FlowLayout CENTER_ROOT_PANE_LAYOUT;
    private static final int DEFAULT_V_GAP = (int) (AppUIManager.SCREEN_HEIGHT/4.5);

    protected HomeMenu()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setLayout(null);

        //Init Center Root Pane
        CENTER_ROOT_PANE_LAYOUT = new FlowLayout(FlowLayout.CENTER);
        CENTER_ROOT_PANE_LAYOUT.setVgap(10);
        CENTER_ROOT_PANE = new JPanel(CENTER_ROOT_PANE_LAYOUT);
        CENTER_ROOT_PANE.setBounds(50, 0, AppWindow.MENU_VIEW_PORT.width - 100, AppUIManager.SCREEN_HEIGHT);
        CENTER_ROOT_PANE.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        add(CENTER_ROOT_PANE);
    }

    private void initComponents()
    {
        //Create Sets label
        WORKOUT_PLAN_UI = new WorkoutPlanUI(new WorkoutPlan("WorkoutPlan 1"));

        //Init Workout Plan view
        CENTER_ROOT_PANE.add(WORKOUT_PLAN_UI);

        //Init Buttons
        ButtonFactory factory = new ButtonFactory();

        BACKWARD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.HOME_MENU_ARROW_BUTTON,
                "angle-circle-left.png",null);
        add(BACKWARD_BUTTON);
        BACKWARD_BUTTON.setBounds(0, (AppUIManager.SCREEN_HEIGHT/2) - 25,
                BACKWARD_BUTTON.getWidth(), BACKWARD_BUTTON.getHeight());

        FORWARD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.HOME_MENU_ARROW_BUTTON,
                "angle-circle-right.png",null);
        add(FORWARD_BUTTON);
        FORWARD_BUTTON.setBounds(AppWindow.MENU_VIEW_PORT.width - 50, (AppUIManager.SCREEN_HEIGHT/2) - 25,
                FORWARD_BUTTON.getWidth(), FORWARD_BUTTON.getHeight());
    }
}
