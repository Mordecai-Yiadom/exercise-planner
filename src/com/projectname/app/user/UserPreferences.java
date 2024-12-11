package com.projectname.app.user;

public class UserPreferences
{

    private String medicalHistory;
    private String goal;
    private String fitnessLevel; /* Beginner/Intermediate/Advanced
     ***MAKE ENUM***

     (for future workage)
     level will indicate access to database of exercises/workouts in database
     (could only be for workout planner generator)

     Beginner - Beginner Level Workouts
     Intermediate - Interm. and Beginner
     Advanced - Advanced / Interm. / Beginner


    */

    private int timePerWeek;
    private int timePerSession;
    private String preferredIntensity; /* LOW / MEDIUM / HIGH / NO PREF
    ***MAKE ENUM?***
    (for future workage)

    */

    private String preferredWorkoutLocation;/* HOME / GYM / OUTSIDE / NO PREF
    ***MAKE ENUM***
     */

    private String equipment;




    public String getMedicalHistory(){ return this.medicalHistory;}

    public String getGoal(){ return this.goal;}

    public String getFitnessLevel(){ return this.fitnessLevel;}

    public int getTimePerWeek(){ return this.timePerWeek;}

    public int getTimePerSession(){ return this.timePerSession;}

    public String getPreferredIntensity(){return this.preferredIntensity}

    public String getPreferredWorkoutLocation(){return this.preferredWorkoutLocation;}

    public String getEquipment(){return this.equipment;}




    public void setMedicalHistory(String userMedicalHistory){this.medicalHistory = userMedicalHistory;}

    public void setGoal(String userGoal){this.goal = userGoal;}

    public void setFitnessLevel(String userFitnessLevel){this.fitnessLevel = userFitnessLevel;}

    public void setTimePerWeek(int userTimePerWeek){this.timePerWeek = userTimePerWeek;}

    public void setTimePerSession(int userTimePerSession){this.timePerSession = userTimePerSession;}

    public void setPreferredIntensity(String userPreferredIntensity){this.preferredIntensity = userPreferredIntensity;}

    public void setPreferredWorkoutLocation(String userPerferredLocation){this.preferredWorkoutLocation = userPerferredLocation;}

}
