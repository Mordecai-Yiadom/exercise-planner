package com.projectname.app.exercise;

public class UserSettings {

    // based on questionnaire
    private String mainGoal; // question 1
    private String currentGoal;

    private String currentFocus;

    private String level;
    private int weeklyDedicationTime;
    private int sessionDedicationTime;

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
