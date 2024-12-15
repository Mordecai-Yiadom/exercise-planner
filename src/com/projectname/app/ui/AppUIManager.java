package com.projectname.app.ui;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.DefaultExerciseType;
import com.projectname.app.exercise.Exercise;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Set;

public class AppUIManager
{
    public static final String FONT = "Segoe UI";

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 900;

    public static final int DECORATION_OFFSET = 0;

    public static final Color MENU_BACKGROUND_COLOR = new Color(54, 54, 64);
    public static final String IMAGE_PATH = "/assets/images/ui/";

    private static AppWindow APPWINDOW;

    //REMOVE WHEN UI IS COMPLETE
    protected static JLabel createTestLabel(String text, int size)
    {
        JLabel label = new JLabel(text);
        label.setFont(new Font(FONT, Font.BOLD, size));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.RED);
        return label;
    }

    public static void launchUI()
    {
        APPWINDOW = new AppWindow();
        APPWINDOW.displayMenu(new HomeMenu());
        APPWINDOW.setVisible(true);
    }

    private static void createTestWorkoutPlans()
    {
        LocalDatabase localDatabase = Application.instance().getLocalDatabase();
        WorkoutPlan workoutPlan = new WorkoutPlan();

        workoutPlan.addExercise(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.MEDIUM,
                10l, "Jumping Jacks", "jump up and down"));

        workoutPlan.addExercise(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.HIGH,
                4.1f, "Jog", "jog to and from"));

        workoutPlan.addExercise(new Exercise(DefaultExerciseType.STRONGMAN, Exercise.Intensity.LOW,
                5, "Pull up", "pull up and down"));

        workoutPlan.addExercise(new Exercise());
        localDatabase.addWorkoutPlan(workoutPlan);
    }

    protected static void createTestExercises()
    {
        LocalDatabase localDatabase = Application.instance().getLocalDatabase();
        localDatabase.addExercise(new Exercise(DefaultExerciseType.CALISTHENICS, Exercise.Intensity.HIGH,
               12, "Push-ups", "push up and down"));

        localDatabase.addExercise(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.MEDIUM,
                10l, "Jumping Jacks", "jump up and down"));

        localDatabase.addExercise(new Exercise(DefaultExerciseType.CARDIO, Exercise.Intensity.HIGH,
                4.1f, "Jog", "jog to and from"));

        localDatabase.addExercise(new Exercise(DefaultExerciseType.STRONGMAN, Exercise.Intensity.LOW,
             5, "Pull up", "pull up and down"));

        localDatabase.addExercise(new Exercise(DefaultExerciseType.CROSSFIT, Exercise.Intensity.MEDIUM,
                20, "Curl", "curl up and down"));
    }

    protected static AppWindow window(){return APPWINDOW;}

    public static void terminateUI()
    {
        APPWINDOW = null;
    }
}
