package com.projectname.app.exercise;

public class UserSettings {

    // based on questionnaire
    private String mainGoal;
    private String currentGoal;

    private String currentFocus;

    private String level;
    private int weeklyDedicationTime;
    private int sessionDedicationTime;


    /* should only ask a few questions (comment out some for now) to make process fast for users,
     then add an option for users to answer more if they want
     */

    private String [] questions = {
            "Do you have any medical conditions or injuries?", // if yes output disclaimer > prompt to continue
            "What is your main goal?",
            //"How would you describe your fitness level?",
            //"What do you want to focus on?",
            //"How would you describe your fitness level?",
            "How many times a week can you dedicate or want to dedicate?",
            "How much time can you spend on each session?",
            //"What kind of workouts do you enjoy?",
            "Where do you prefer working out?",
            "What equipment do you have access to? (Select all that apply)"
    };


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


    public UserSettings() {}

    public UserSettings(String mainGoal, String currentGoal, String currentFocus, String level,
                        int weeklyDedicationTime, int sessionDedicationTime) {
        this.mainGoal = mainGoal;
        this.currentGoal = currentGoal;
        this.currentFocus = currentFocus;
        this.level = level;
        this.weeklyDedicationTime = weeklyDedicationTime;
        this.sessionDedicationTime = sessionDedicationTime;
    }

    public String getMainGoal() {return mainGoal;}

    public String getCurrentGoal() {return currentGoal;}

    public String getCurrentFocus() {return currentFocus;}

    public String getLevel() {return level;}

    public int getWeeklyDedicationTime() {return weeklyDedicationTime;}

    public int getSessionDedicationTime() {return sessionDedicationTime;}

}
