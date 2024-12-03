package com.projectname.app;

/*
 * Manages file io, directory create, and all other file related operations for the application
 */

import java.io.*;

public class FileManager
{
    protected static final File HOME_DIRECTORY = new File("C:/ExercisePlanner");
    protected static final File LOCAL_DATABASE_FILE = new File("LOCAL_DATABASE.bin");

    protected static final File USER_SETTINGS_FILE = new File("USER_SETTINGS.bin");

    protected static void init() throws IOException
    {
        HOME_DIRECTORY.mkdir();
        LOCAL_DATABASE_FILE.createNewFile();
        USER_SETTINGS_FILE.createNewFile();
    }

    protected static boolean saveObjectToFile(File file, Object object)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);
            return true;
        }
        catch(Exception ex) {ex.printStackTrace();}
        return false;
    }

    protected static Object loadObjectFromFile(File file)
    {
        Object object = null;
        try
        {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            object = objectInputStream.readObject();
        }
        catch(Exception ex) {ex.printStackTrace();}
        return object;
    }
}
