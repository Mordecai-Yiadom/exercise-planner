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
    private JPanel ROOT_PANE;
    private JLabel WORKOUT_NAME, WORKOUT_SETS;
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

        String borderTitle = String.format("%s || (%d sets)", workoutPlan.getName(), workoutPlan.getNumOfSets());

        BORDER = BorderFactory.createLineBorder(Toolbar.BACKGROUND_COLOR, 10, true);
        BORDER = BorderFactory.createTitledBorder(BORDER, borderTitle, TitledBorder.CENTER,
                TitledBorder.ABOVE_TOP, new Font(AppUIManager.FONT, Font.BOLD, 30), Color.WHITE);
        setBorder(BORDER);
    }

    private void initComponents() {
        //Init RootPane
        int numOfExercises = workoutPlan.getExercises().size();
        ROOT_PANE = new JPanel();
        ROOT_PANE.setBackground(Toolbar.BACKGROUND_COLOR);
        ROOT_PANE.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                Toolbar.BACKGROUND_COLOR, Toolbar.BACKGROUND_COLOR));
        ROOT_PANE.setLayout(new GridLayout(numOfExercises + 1, 1, 0, 5));
        setViewportView(ROOT_PANE);


        //Add Exercises
        if(workoutPlan.getExercises().isEmpty())
        {
            JLabel label = new JLabel("This plan is empty.");
            label.setFont(new Font(AppUIManager.FONT, Font.BOLD, 20));
            label.setBackground(ROOT_PANE.getBackground());
            label.setForeground(Color.WHITE);
            label.setLayout(new FlowLayout(FlowLayout.CENTER));
            ROOT_PANE.add(label);
        }
        else for(Exercise exercise : workoutPlan.getExercises()) ROOT_PANE.add(new WorkoutPlanEntryUI(exercise));
    }

    protected WorkoutPlan getWorkoutPlan() {return workoutPlan;}
}
