package com.projectname.app.user;

/*
 * Program that gets initial user settings for Application
 * Singleton class
 */
public class Questionnaire
{
    public static UserPreferences start()
    {
        return null;
    }



    private String [][] answerChoices = {

            {"Losing weight", "Building muscle", "Improve endurance", "Personal growth",
                    "Maintaining health", "IDK", "Aesthetic", "Something else"},

            /*
            {"Beginner - little to no experience with structured workouts",
            "Intermediate - Some experience with workouts but not consistent",
            "Advanced - consistent workouts with experience in specific training types"},
             */

            {"Home", "Gym", "Outdoors", "No Preference"},

            {"Dumbbells", "Barbells", "Resistance bands", "Yoga mat",
                    "Cardio machines (e.g., treadmill, bike)", "Bodyweight"
                    /*"Other (please specify)"
                     */},
    };


    public enum Question
    {
        //put questions here;
        QUESTION_1("Do you have any medical conditions or injuries?"), // if yes output disclaimer > prompt to continue


        QUESTION_2("What is your main goal?"),

        QUESTION_3("How would you describe your fitness level?"),
                //"What do you want to focus on?",

        QUESTION_4("How many times a week can you dedicate or want to dedicate?"),
        QUESTION_5("How much time can you spend on each session?"),
        QUESTION_N("What's your preferred intensity?"),
                //"What kind of workouts do you enjoy?",

        QUESTION_6("Where do you prefer working out?"),

        QUESTION_7("What equipment do you have access to? (Select all that apply)")
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
