package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class DatabaseEditHomeMenu extends JPanel implements AppMenu
{
    private JButton MANAGE_WORKOUT_PLANS_BUTTON, MANAGE_EXERCISES_BUTTON;

    protected DatabaseEditHomeMenu()
    {
        init();
        initComponents();
    }

    private void init()
    {
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        setLayout(layout);
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        layout.setVgap(AppUIManager.SCREEN_HEIGHT/3);
        layout.setHgap(20);

    }

    private void initComponents()
    {
        ButtonFactory factory = new ButtonFactory();
        MANAGE_WORKOUT_PLANS_BUTTON = factory.createTextButton(ButtonFactory.GenericType.DATABASE_EDIT_EDIT_HOME_MENU_BUTTON,
                "Add/Remove Workout Plans");
        MANAGE_WORKOUT_PLANS_BUTTON.setHorizontalTextPosition(SwingConstants.CENTER);
        MANAGE_WORKOUT_PLANS_BUTTON.setBorder(BorderFactory.createLineBorder(MANAGE_WORKOUT_PLANS_BUTTON.getBackground(),
                20, true));
        add(MANAGE_WORKOUT_PLANS_BUTTON);

        MANAGE_EXERCISES_BUTTON = factory.createTextButton(ButtonFactory.GenericType.DATABASE_EDIT_EDIT_HOME_MENU_BUTTON,
                "Add/Remove Exercises");
        MANAGE_EXERCISES_BUTTON.setHorizontalTextPosition(SwingConstants.CENTER);
        MANAGE_EXERCISES_BUTTON.setBorder(BorderFactory.createLineBorder(MANAGE_EXERCISES_BUTTON.getBackground(),
                20, true));
        add(MANAGE_EXERCISES_BUTTON);

        MANAGE_WORKOUT_PLANS_BUTTON.addActionListener((e)->
        {AppUIManager.window().displayMenu(new DatabaseEditWorkoutPlansMenu());});

        MANAGE_EXERCISES_BUTTON.addActionListener((event)->
        {AppUIManager.window().displayMenu(new DatabaseEditExerciseMenu());});

    }


}
