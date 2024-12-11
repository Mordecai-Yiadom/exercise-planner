package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.exercise.ExerciseType;

import javax.swing.*;
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

        //Init Content Pane
        //TODO number of rows should be based on local database query
        GridLayout layout = new GridLayout(3, 3, 20,20);
        CONTENT_PANE = new JPanel(layout);
        CONTENT_PANE.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
    }

    private void initComponents()
    {

    }

    private void addUIExercises(ExerciseType exerciseType)
    {
        Application.instance().getLocalDatabase().exerciseDatatableSize();
    }

    private void addUIExercise()
    {

    }

    private static class CategoryBar extends JPanel
    {
        private Hashtable<ExerciseType, JButton> buttonTable;
        private ButtonGroup buttonGroup;

        private CategoryBar()
        {}

        private void init()
        {
            buttonGroup = new ButtonGroup();
            buttonTable = new Hashtable<>();
        }

        private void initComponents()
        {

        }
    }
}
