package com.projectname.app.ui;

import com.projectname.app.exercise.Exercise;

import javax.swing.*;
import java.awt.*;

public class WorkoutPlanEntryUI extends JPanel
{
    //Constants
    public static final Color BACKGROUND_COLOR = new Color(24,24,24);

    //Instance Variables
    private Exercise exercise;
    private JLabel durationLabel, numOfRepsLabel, exerciseName;

    protected WorkoutPlanEntryUI()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setBackground(BACKGROUND_COLOR);

    }

    private void initComponents()
    {

    }
}
