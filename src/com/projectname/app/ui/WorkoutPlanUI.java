package com.projectname.app.ui;

import com.projectname.app.exercise.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;

public class WorkoutPlanUI extends JScrollPane
{
    //Constants
    public static final Color BACKGROUND_COLOR = new Color(94,94,104);

    //Instance Variables
    private static JPanel ROOT_PANE;
    private WorkoutPlan workoutPlan;
    private JScrollBar SCROLL_BAR;

    //Constructor(s)
    protected WorkoutPlanUI(WorkoutPlan workoutPlan)
    {
        this.workoutPlan = workoutPlan;

        init();
        initComponents();
    }

    private void init()
    {
        //Basic Setup
        setBackground(Color.RED);
        setUI(new BasicScrollPaneUI());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void initComponents()
    {
        //Init RootPane
        ROOT_PANE = new JPanel();
        ROOT_PANE.setBackground(Color.RED);
        ROOT_PANE.setLayout(new BoxLayout(ROOT_PANE, BoxLayout.Y_AXIS));
        setViewportView(ROOT_PANE);


        ROOT_PANE.add(new WorkoutPlanEntryUI(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.LOW,
                10l, "Jumping Jacks", "jump up and down")));

        ROOT_PANE.add(new WorkoutPlanEntryUI(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.LOW,
                17l, "Push-ups", "push up and down")));


        //ROOT_PANE.add(AppUIManager.createTestLabel("My Workout Plan Rocks", 50));

    }
}
