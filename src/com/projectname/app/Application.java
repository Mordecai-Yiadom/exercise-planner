package com.projectname.app;

import com.projectname.app.exercise.Exercise;
import com.projectname.app.exercise.WorkoutPlan;
import com.projectname.app.ui.AppUIManager;
import com.projectname.app.ui.AppWindow;

import java.io.IOException;

/* An instance of the Application running.
 * It contains global variables and functions concerning the application
 *
 * This class follows singleton design pattern
 */
public class Application {
    private static Application INSTANCE;

    private LocalDatabase LOCAL_DATABASE;
    private Schedule USER_SCHEDULE;
    private ReminderManager REMINDER_MANAGER;

    private Application() {
        try {
            FileManager.init();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    //Static Methods
    public static Application instance() {
        return INSTANCE;
    }

    public static Application launch(String[] args) {
        //Create Application instance
        if (INSTANCE == null) INSTANCE = new Application();

        //Load Object Files
        INSTANCE.loadLocalDatabase();
        INSTANCE.loadUserSchedule();
        INSTANCE.loadReminderManager();

        //Launch UI
        AppUIManager.launchUI();
        System.out.println("Application has started");

        return INSTANCE;
    }

    public static void terminate() {
        INSTANCE.saveLocalDatabase();
        INSTANCE.saveUserSchedule();
        INSTANCE.saveReminderManager();

        AppUIManager.terminateUI();

        INSTANCE = null;
        System.out.println("Application has been terminated");
    }

    public static boolean isRunning()
    {
        return (INSTANCE != null);
    }
    //Instance Methods

    //TODO implement this method
    public void triggerReminder() {
    }

    public LocalDatabase getLocalDatabase() {
        return LOCAL_DATABASE;
    }

    public Schedule getUserSchedule()
    {
        return USER_SCHEDULE;
    }

    public ReminderManager getReminderManager()
    {
        return REMINDER_MANAGER;
    }

    private void loadLocalDatabase() {
        LOCAL_DATABASE = (LocalDatabase) FileManager.loadObjectFromFile(FileManager.LOCAL_DATABASE_FILE);
        if (LOCAL_DATABASE == null) LOCAL_DATABASE = new LocalDatabase();
    }

    private void loadUserSchedule() {
        USER_SCHEDULE = (Schedule) FileManager.loadObjectFromFile(FileManager.USER_SCHEDULE_FILE);
        if (USER_SCHEDULE == null) USER_SCHEDULE = new Schedule();
    }

    private void loadReminderManager()
    {
        REMINDER_MANAGER = (ReminderManager) FileManager.loadObjectFromFile(FileManager.REMINDER_MANAGER_FILE);
        if(REMINDER_MANAGER == null) REMINDER_MANAGER = new ReminderManager();
    }


    private void loadUserSettings() {
    }

    private void saveLocalDatabase() {
        FileManager.saveObjectToFile(FileManager.LOCAL_DATABASE_FILE, LOCAL_DATABASE);
    }

    private void saveUserSchedule()
    {
        FileManager.saveObjectToFile(FileManager.USER_SCHEDULE_FILE, USER_SCHEDULE);
    }

    private void saveReminderManager()
    {
        FileManager.saveObjectToFile(FileManager.REMINDER_MANAGER_FILE, REMINDER_MANAGER);
    }
}
