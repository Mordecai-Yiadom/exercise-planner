package com.projectname.app.ui;

import com.projectname.app.AppReminder;
import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.exercise.DefaultExerciseType;
import com.projectname.app.exercise.Exercise;
import com.projectname.app.exercise.WorkoutPlan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.net.URL;
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
    public static final String APP_ICON = IMAGE_PATH + "app-icon.png";

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

        try
        {
            URL imageURL = AppUIManager.class.getResource(APP_ICON);
            APPWINDOW.setIconImage(new ImageIcon(imageURL).getImage());
        }
        catch(Exception ex) {ex.printStackTrace();}

        APPWINDOW.displayMenu(new HomeMenu());
        APPWINDOW.setVisible(true);
    }

    public static void minimize()
    {
        new MinimizedWindow();
    }

    public static void launchReminder(AppReminder reminder)
    {
        new ReminderWindow();
    }

    public static AppWindow window(){return APPWINDOW;}

    public static void terminateUI()
    {
        APPWINDOW = null;
    }
}
