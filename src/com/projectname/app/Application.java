package com.projectname.app;

import com.projectname.app.ui.AppUIManager;
import com.projectname.app.ui.AppWindow;

import java.io.IOException;

/* An instance of the Application running.
 * It contains global variables and functions concerning the application
 *
 * This class follows singleton design pattern
 */
public class Application
{
    private static Application INSTANCE;

    private LocalDatabase LOCAL_DATABASE;

    private Application()
    {
        try
        {
            FileManager.init();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    public static Application instance() {return INSTANCE;}

    public static Application launch(String[] args)
    {
        //Create Application instance
       if(INSTANCE == null) INSTANCE = new Application();

       AppUIManager.launchUI();
       INSTANCE.loadLocalDatabase();

       System.out.println("Application has started");

       return INSTANCE;
    }

    public static void terminate()
    {
        INSTANCE.saveLocalDatabase();
        AppUIManager.terminateUI();

        INSTANCE = null;
        System.out.println("Application has been terminated");
    }

    //TODO implement this method
    public void triggerReminder()
    {}

    private void loadLocalDatabase()
    {
        LOCAL_DATABASE = (LocalDatabase) FileManager.loadObjectFromFile(FileManager.LOCAL_DATABASE_FILE);
        if(LOCAL_DATABASE == null) LOCAL_DATABASE = new LocalDatabase();
    }

    private void loadUserSettings()
    {}

    private void saveLocalDatabase()
    {
        FileManager.saveObjectToFile(FileManager.LOCAL_DATABASE_FILE, LOCAL_DATABASE);
    }
}
