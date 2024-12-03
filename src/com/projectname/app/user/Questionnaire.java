package com.projectname.app.user;

/*
 * Program that gets initial user settings for Application
 * Singleton class
 */
public class Questionnaire
{
    public static UserSettings start()
    {
        return null;
    }

    public enum Question
    {
        //put questions here;
        ;

        private String question;
        Question(String question)
        {
           this.question = question;
        }

        @Override
        public String toString(){return question;};
    }
}
