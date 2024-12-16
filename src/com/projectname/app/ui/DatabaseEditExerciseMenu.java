package com.projectname.app.ui;

import com.projectname.app.*;
import com.projectname.app.exercise.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DatabaseEditExerciseMenu extends JScrollPane implements AppMenu
{
    private JPanel CONTENT_PANE;
    private JButton ADD_BUTTON;
    private Border WORKOUT_ENTRY_BORDER = BorderFactory.createLineBorder(Toolbar.BACKGROUND_COLOR,
            5, true);

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
        ButtonFactory factory = new ButtonFactory();
        ADD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.DATABASE_ADD_BUTTON,
                "add.png", null);
        ADD_BUTTON.setToolTipText("Add New Exercise to Database");
        ADD_BUTTON.addActionListener((e)->{new CreateExerciseWindow();});
        CONTENT_PANE.add(ADD_BUTTON);
    }

    private void addUIExercises(ExerciseType exerciseType)
    {
        for(Exercise exercise : Application.instance().getLocalDatabase().getExercises(exerciseType))
        {
            WorkoutPlanEntryUI workoutPlanEntryUI = new WorkoutPlanEntryUI(exercise);
            CONTENT_PANE.add(workoutPlanEntryUI);

            JButton removeButton = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_REMOVE_BUTTON,
                "cross-circle.png", null);

        }
    }

    private void addUIExercises()
    {
        for(Exercise exercise : Application.instance().getLocalDatabase().getExercises())
        {
            WorkoutPlanEntryUI workoutPlanEntryUI = new WorkoutPlanEntryUI(exercise);
            workoutPlanEntryUI.setBorder(WORKOUT_ENTRY_BORDER);

            JPanel buttonPanel = createBackPanel(createRemoveButton(workoutPlanEntryUI));
            buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));

            JPanel backPanel = createBackPanel(workoutPlanEntryUI, buttonPanel);

            CONTENT_PANE.add(backPanel);
        }
    }

    private JPanel createBackPanel(Component... components)
    {
        JPanel panel = new JPanel(new GridLayout(1,2));
        panel.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);

        for(Component c : components) panel.add(c);
        return panel;
    }

    private JButton createRemoveButton(WorkoutPlanEntryUI workoutPlanEntryUI)
    {
        JButton button = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_REMOVE_BUTTON,
                "cross-circle.png", null);
        button.addActionListener(new RemoveExerciseListener(workoutPlanEntryUI));
        button.setToolTipText("Remove Exercise From Database");
        return button;
    }

    private static class RemoveExerciseListener implements ActionListener
    {
        private WorkoutPlanEntryUI workoutPlanEntryUI;

        private RemoveExerciseListener(WorkoutPlanEntryUI workoutPlanEntryUI)
        {
            this.workoutPlanEntryUI = workoutPlanEntryUI;
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Application.instance().getLocalDatabase().removeExercise(workoutPlanEntryUI.getExercise());

           AppUIManager.window().displayMenu(new DatabaseEditExerciseMenu());
            System.out.println("Removed Exercise");
        }
    }
}
