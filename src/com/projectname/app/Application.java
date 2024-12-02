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
    private Application()
    {
        try
        {
            fileManager = new FileManager();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    private FileManager fileManager;

    public static Application instance() {return INSTANCE;}

    public static Application launch(String[] args)
    {
        //Create Application instance
       if(INSTANCE == null) INSTANCE = new Application();
       AppUIManager.launchUI();
       System.out.println("Application has started");

       return INSTANCE;
    }

    public static void terminate()
    {
        AppUIManager.terminateUI();
        INSTANCE = null;
        System.out.println("Application has been terminated");
    }

    private void kill()
    {}
}
