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
    private JLabel durationLabel, numOfRepsLabel, distanceLabel, exerciseNameLabel, intensityLabel;

    protected WorkoutPlanEntryUI(Exercise exercise)
    {
        this.exercise = exercise;

        init();
        initComponents();
    }

    private void init()
    {
        setBackground(Toolbar.BACKGROUND_COLOR);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setHgap(5);
        layout.setVgap(0);
    }

    private void initComponents()
    {
        LabelFactory labelFactory = new LabelFactory();

        //Duration label
        if(exercise.hasDuration())
        {
            durationLabel = labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_DURATION_LABEL,
                    exercise.getDuration() + " secs");

            add(durationLabel);
        }
        else if(exercise.hasReps())
        {}
        else
        {}

        //Add Name Label
        exerciseNameLabel = labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_NAME_LABEL,
                exercise.getName());

        add(exerciseNameLabel);
        //Add Intensity Label

    }

    private void readExercise()
    {

    }
}
