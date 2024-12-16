package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.util.Collection;

public class WorkoutPlanUI extends JScrollPane {
    //Constants
    public static final Color BACKGROUND_COLOR = new Color(94, 94, 104);

    //Instance Variables
    private static JPanel ROOT_PANE;
    private WorkoutPlan workoutPlan;
    private JScrollBar SCROLL_BAR;
    private Border BORDER;

    //Constructor(s)
    protected WorkoutPlanUI(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;

        init();
        initComponents();
    }

    private void init() {
        //Basic Setup
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setForeground(Color.WHITE);
        setUI(new BasicScrollPaneUI());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        setPreferredSize(new Dimension(700, 500));

        BORDER = BorderFactory.createLineBorder(Toolbar.BACKGROUND_COLOR, 10, true);
        setBorder(BORDER);
    }

    private void initComponents() {
        //Init RootPane
        ROOT_PANE = new JPanel();
        ROOT_PANE.setBackground(Toolbar.BACKGROUND_COLOR);
        ROOT_PANE.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                Toolbar.BACKGROUND_COLOR, Toolbar.BACKGROUND_COLOR));
        ROOT_PANE.setLayout(new GridLayout(20, 1, 0, 5));
        setViewportView(ROOT_PANE);

         /***
         * TEST CODE BELOW -- REMOVE THIS WHEN POSSIBLE
         ***/

         //for(Exercise exercise : workoutPlan.getExercise)
         //{
           //  ROOT_PANE.add(new WorkoutPlanEntryUI(exercise));
         //}

        ROOT_PANE.add(new WorkoutPlanEntryUI(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.MEDIUM,
                10l, "Jumping Jacks", "jump up and down")));

        ROOT_PANE.add(new WorkoutPlanEntryUI(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.HIGH,
                12, "Push-ups", "push up and down")));
    }

    protected WorkoutPlan getWorkoutPlan() {return workoutPlan;}
}
