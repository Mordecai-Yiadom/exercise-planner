package com.projectname.app;

/* An instance of the Application running.
 * It contains global variables and functions concerning the application
 *
 * This class follows singleton design pattern
 */
public class Application
{
    private static Application INSTANCE;
    private Application(){}

    public static Application instance() {return INSTANCE;}

    public static void launch(String[] args)
    {
        //Create Application instance
       if(INSTANCE == null)
           INSTANCE = new Application();

       System.out.println("Application has started");
    }

    public static void terminate()
    {
    }
}
