package com.projectname.app;

/*
 * Manages file io, directory create, and all other file related operations for the application
 */

import java.io.File;
import java.io.IOException;

public class FileManager
{
    protected static final File HOME_DIRECTORY = new File("C:/ExercisePlanner");
    private File EXERCISE_DATABASE, WORKOUT_PLAN_DATABASE, EXERCISE_TYPE_DATABASE, USER_SETTINGS;

    protected FileManager() throws IOException
    {
        createHomeDirectory();

        EXERCISE_DATABASE = new File(HOME_DIRECTORY, "exercise-database.json");
        WORKOUT_PLAN_DATABASE = new File(HOME_DIRECTORY, "workout-plan-database.json");
        EXERCISE_TYPE_DATABASE = new File(HOME_DIRECTORY, "exercise-type-database.txt");
        USER_SETTINGS = new File(HOME_DIRECTORY, "user-settings.json");

        if(!EXERCISE_DATABASE.exists()) EXERCISE_DATABASE.createNewFile();
        if(!WORKOUT_PLAN_DATABASE.exists()) WORKOUT_PLAN_DATABASE.createNewFile();
        if(!EXERCISE_TYPE_DATABASE.exists()) EXERCISE_TYPE_DATABASE.createNewFile();
        if(!USER_SETTINGS.exists()) USER_SETTINGS.createNewFile();
    }
    private boolean createHomeDirectory() {return HOME_DIRECTORY.mkdir();}

    protected boolean writeToFile(File file, String content)
    {
        return false;
    }
}
