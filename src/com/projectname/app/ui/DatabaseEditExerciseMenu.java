package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.exercise.Exercise;
import com.projectname.app.exercise.ExerciseType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.util.Hashtable;
import java.util.function.Predicate;

public class DatabaseEditExerciseMenu extends JScrollPane implements AppMenu
{
    private JPanel CONTENT_PANE;
    protected DatabaseEditExerciseMenu()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setUI(new BasicScrollPaneUI());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        //Init Content Pane
        //TODO number of rows should be based on local database query

        CONTENT_PANE = new JPanel();
        GridLayout layout = new GridLayout(20,1,0,10);
        CONTENT_PANE.setLayout(layout);
        CONTENT_PANE.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setViewportView(CONTENT_PANE);
    }

    private void initComponents()
    {
        addUIExercises();
    }

    private void addUIExercises(ExerciseType exerciseType)
    {
        Application.instance().getLocalDatabase().exerciseDatatableSize();
    }

    private void addUIExercises()
    {
        for(Exercise exercise : Application.instance().getLocalDatabase().getExercises())
        {
            WorkoutPlanEntryUI workoutPlanEntryUI = new WorkoutPlanEntryUI(exercise);
            CONTENT_PANE.add(workoutPlanEntryUI);
        }
    }

}
