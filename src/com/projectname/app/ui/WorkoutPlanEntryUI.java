package com.projectname.app.ui;

import com.projectname.app.exercise.Exercise;

import javax.swing.*;
import java.awt.*;

public class WorkoutPlanEntryUI extends JPanel
{
    //Constants
    public static final Color BACKGROUND_COLOR = new Color(54, 54, 74);

    //Instance Variables
    private Exercise exercise;
    private GridLayout LAYOUT;
    private JPanel LEFT_PANEL_TOP, LEFT_PANEL_BOTTOM;
    private JPanel LEFT_PANEL, RIGHT_PANEL;
    private JLabel subLabel, exerciseNameLabel, intensityLabel, exerciseTypeLabel;


    protected WorkoutPlanEntryUI(Exercise exercise)
    {
        this.exercise = exercise;

        init();
        initComponents();
    }

    private void init()
    {
        setBackground(Toolbar.BACKGROUND_COLOR);
        LAYOUT = new GridLayout(1,2);
        setLayout(LAYOUT);

        //Init
        LEFT_PANEL_TOP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        LEFT_PANEL_TOP.setBackground(BACKGROUND_COLOR);

        LEFT_PANEL_BOTTOM = new JPanel(new GridLayout(2,1, 5, 5));
        LEFT_PANEL_BOTTOM.setBackground(BACKGROUND_COLOR);

        //Init Left & Right Panels
        LEFT_PANEL = new JPanel(new GridLayout(2,1));
        RIGHT_PANEL = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 30));
        RIGHT_PANEL.setBackground(BACKGROUND_COLOR);

        LEFT_PANEL.add(LEFT_PANEL_TOP);
        LEFT_PANEL.add(LEFT_PANEL_BOTTOM);

        add(LEFT_PANEL);
        add(RIGHT_PANEL);
    }

    private void initComponents()
    {
        LabelFactory labelFactory = new LabelFactory();

        //Create sub label based on exercise object
        subLabel = createSubLabel();

        //Create exercise name label
        exerciseNameLabel = labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_NAME_LABEL,
                exercise.getName());

        exerciseTypeLabel = labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_SUB_LABEL,
                exercise.getType().toString());
        exerciseTypeLabel.setForeground(Color.LIGHT_GRAY);

        intensityLabel = createIntensityLabel();

        LEFT_PANEL_TOP.add(exerciseNameLabel);
        RIGHT_PANEL.add(intensityLabel);
        LEFT_PANEL_BOTTOM.add(exerciseTypeLabel);
        LEFT_PANEL_BOTTOM.add(subLabel);
    }

    protected Exercise getExercise(){return exercise;}
    private void readExercise()
    {

    }

    private JLabel createSubLabel()
    {
        LabelFactory labelFactory = new LabelFactory();
        //Create Sub-label
        if(exercise.hasDuration())
        {
            String duration = String.format("Duration: %d seconds", exercise.getDuration());
            return labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_SUB_LABEL, duration);
        }
        else if(exercise.hasReps())
        {
            String numOfReps = String.format("Reps: %d", exercise.getNumOfReps());
            return labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_SUB_LABEL, numOfReps);
        }
        else
        {
            String distance = String.format("Distance: %.1f miles", exercise.getDistance());
            return labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_ENTRY_SUB_LABEL, distance);
        }
    }

    private JLabel createIntensityLabel()
    {
        LabelFactory labelFactory = new LabelFactory();

        JLabel label = labelFactory.createTextLabel(LabelFactory.GenericType.WORKOUT_PLAN_INTENSITY_LEVEL_LABEL,
                "Low Intensity");

        switch(exercise.getIntensity())
        {
            case MEDIUM:
                label.setText("Medium Intensity");
                label.setBackground(new Color(197, 147, 6));
                break;
            case HIGH:
                label.setText("High Intensity");
                label.setBackground(Color.RED);
                break;
        }
        return label;
    }
}
