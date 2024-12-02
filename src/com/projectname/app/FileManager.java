package com.projectname.app;

/*
 * Manages file io, directory create, and all other file related operations for the application
 */

import java.io.File;

public class FileManager
{
    protected static final File HOME_DIRECTORY = new File("C:/ExercisePlanner");
    protected FileManager()
    {
        createHomeDirectory();
    }
    private boolean createHomeDirectory()
    {
        return HOME_DIRECTORY.mkdir();
    }

    protected boolean writeToFile(File file, String content)
    {
        return false;
    }


}
