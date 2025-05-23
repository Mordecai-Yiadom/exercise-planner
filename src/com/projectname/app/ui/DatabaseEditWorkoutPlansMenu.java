package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseEditWorkoutPlansMenu extends JScrollPane implements AppMenu
{
    private JPanel CONTENT_PANE;
    private JButton ADD_BUTTON;

    protected DatabaseEditWorkoutPlansMenu()
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

        CONTENT_PANE = new JPanel();
        GridLayout layout = new GridLayout(Application.instance().getLocalDatabase()
                .workoutPlanDataListSize() + 1,1,0,10);
        CONTENT_PANE.setLayout(layout);
        CONTENT_PANE.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setViewportView(CONTENT_PANE);
    }


    private void initComponents()
    {
        addWorkoutPlanUIs();
        ADD_BUTTON = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_ADD_BUTTON,
                "add.png", null);
        ADD_BUTTON.setToolTipText("Add new WorkoutPlan to Database");
        ADD_BUTTON.addActionListener((e)->{new CreateWorkoutPlanWindow();});
        CONTENT_PANE.add(ADD_BUTTON);
    }

    private void addWorkoutPlanUIs()
    {
        LocalDatabase database = Application.instance().getLocalDatabase();

        for(WorkoutPlan workoutPlan : database.getWorkoutPlans())
        {
            WorkoutPlanUI workoutPlanUI = new WorkoutPlanUI(workoutPlan);
            CONTENT_PANE.add(createBackPanel(workoutPlanUI, createRemoveButton(workoutPlanUI)));
        }
    }
    private JButton createRemoveButton(WorkoutPlanUI workoutPlanUI)
    {
        JButton button = new ButtonFactory().createIconButton(ButtonFactory.GenericType.DATABASE_REMOVE_BUTTON,
                "cross-circle.png", null);
        button.addActionListener(new RemoveWorkoutPlanListener(workoutPlanUI.getWorkoutPlan()));
        return button;
    }

    private JButton createEditButton()
    {
        return null;
    }

    private JPanel createBackPanel(Component... components)
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(AppUIManager.MENU_BACKGROUND_COLOR);

        for(Component c : components) panel.add(c);
        return panel;
    }

    private static class RemoveWorkoutPlanListener implements ActionListener
    {
        private WorkoutPlan workoutPlan;
        private RemoveWorkoutPlanListener(WorkoutPlan workoutPlan) {this.workoutPlan = workoutPlan;}

        @Override
        public void actionPerformed(ActionEvent event)
        {
            Application.instance().getLocalDatabase().removeWorkoutPlan(workoutPlan);
            AppUIManager.window().displayMenu(new DatabaseEditWorkoutPlansMenu());
            System.out.println("Remove Workout Plan");
        }
    }

    private static class EditWorkoutPlanListener
    {
        private WorkoutPlan workoutPlan;
        private EditWorkoutPlanListener(WorkoutPlan workoutPlan) {this.workoutPlan = workoutPlan;}

    }
}
