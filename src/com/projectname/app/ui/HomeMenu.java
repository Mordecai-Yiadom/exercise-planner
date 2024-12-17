package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.Schedule;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HomeMenu extends JPanel implements AppMenu
{
    //Instance Variables
    private JButton FORWARD_BUTTON, BACKWARD_BUTTON;
    private WorkoutPlanUI WORKOUT_PLAN_UI;
    private JPanel CENTER_ROOT_PANE;
    private JLabel DAY_LABEL, TIME_LABEL;
    private FlowLayout CENTER_ROOT_PANE_LAYOUT;
    private DayOfWeek DAY;
    private static final int DEFAULT_V_GAP = (int) (AppUIManager.SCREEN_HEIGHT/4.5);

    protected HomeMenu(DayOfWeek day)
    {
        this.DAY = day;
        init();
        initComponents();
    }

    protected HomeMenu()
    {
        this(DayOfWeek.MONDAY);
    }

    private void init()
    {
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setLayout(null);

        //Init Center Root Pane
        CENTER_ROOT_PANE_LAYOUT = new FlowLayout(FlowLayout.CENTER);
        CENTER_ROOT_PANE = new JPanel(CENTER_ROOT_PANE_LAYOUT);
        CENTER_ROOT_PANE.setBounds(50, 0, AppWindow.MENU_VIEW_PORT.width - 100, AppUIManager.SCREEN_HEIGHT);
        CENTER_ROOT_PANE.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        CENTER_ROOT_PANE.setPreferredSize(new Dimension(500, AppUIManager.SCREEN_HEIGHT));
        add(CENTER_ROOT_PANE);
    }

    private void initComponents()
    {
        Schedule schedule = Application.instance().getUserSchedule();
        WorkoutPlan workoutPlan = schedule.getWorkoutPlan(DAY);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        DAY_LABEL = new LabelFactory().createTextLabel(LabelFactory.GenericType.HOME_MENU_DAY_LABEL, DAY.name());

        if(workoutPlan == null)
        {
            JLabel messageLabel = createLabel("Nothing planned this day.");
            centerPanel.add(DAY_LABEL);
            centerPanel.add(messageLabel);
        }
        else
        {
            //Create Set label
            WORKOUT_PLAN_UI = new WorkoutPlanUI(schedule.getWorkoutPlan(DAY));

            //Init Day and Time Label
            DAY_LABEL = new LabelFactory().createTextLabel(LabelFactory.GenericType.HOME_MENU_DAY_LABEL, DAY.name());
            TIME_LABEL = new LabelFactory().createTextLabel(LabelFactory.GenericType.HOME_MENU_TIME_LABEL,
                    "(" + schedule.getScheduledTime(DAY).toString() + ")");
            DAY_LABEL.setHorizontalTextPosition(SwingConstants.CENTER);
            TIME_LABEL.setHorizontalTextPosition(SwingConstants.CENTER);

            JPanel dayTimePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            dayTimePanel.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
            dayTimePanel.add(DAY_LABEL);
            dayTimePanel.add(TIME_LABEL);

            centerPanel.add(dayTimePanel);
            centerPanel.add(WORKOUT_PLAN_UI);
        }

        CENTER_ROOT_PANE.add(centerPanel);

        //Init Buttons
        ButtonFactory factory = new ButtonFactory();

        BACKWARD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.HOME_MENU_ARROW_BUTTON,
                "angle-circle-left.png",null);
        add(BACKWARD_BUTTON);
        BACKWARD_BUTTON.setBounds(0, (AppUIManager.SCREEN_HEIGHT/2) - 25,
                BACKWARD_BUTTON.getWidth(), BACKWARD_BUTTON.getHeight());
        BACKWARD_BUTTON.addActionListener((e)->
        {AppUIManager.window().displayMenu(new HomeMenu(DAY.minus(1)));});

        FORWARD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.HOME_MENU_ARROW_BUTTON,
                "angle-circle-right.png",null);
        add(FORWARD_BUTTON);
        FORWARD_BUTTON.setBounds(AppWindow.MENU_VIEW_PORT.width - 50, (AppUIManager.SCREEN_HEIGHT/2) - 25,
                FORWARD_BUTTON.getWidth(), FORWARD_BUTTON.getHeight());
        FORWARD_BUTTON.addActionListener((e)->
        {AppUIManager.window().displayMenu(new HomeMenu(DAY.plus(1)));});
    }

    private JLabel createLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setForeground(Color.DARK_GRAY);
        label.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        label.setFont(new Font(AppUIManager.FONT, Font.BOLD, 30));
        return label;
    }
}
