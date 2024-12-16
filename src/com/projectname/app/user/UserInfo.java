package com.projectname.app.user;

import com.projectname.app.exercise.Exercise;

public class UserInfo
{

    private String medicalHistory;
    private String goal;
    private UserFitnessLevel fitnessLevel; /* Beginner/Intermediate/Advanced

     (for future workage)
     level will indicate access to database of exercises/workouts in database
     (could only be for workout planner generator)

     Beginner - Beginner Level Workouts
     Intermediate - Interm. and Beginner
     Advanced - Advanced / Interm. / Beginner


    */

    private int timePerWeek;
    private int timePerSession;

    private Exercise.Intensity preferredIntensity;

    private String preferredWorkoutLocation;/* HOME / GYM / OUTSIDE / NO PREF
    ***MAKE ENUM***
     */

    private String equipment;




    public String getMedicalHistory(){ return this.medicalHistory;}

    public String getGoal(){ return this.goal;}

    public UserFitnessLevel getFitnessLevel(){ return this.fitnessLevel;}

    public int getTimePerWeek(){ return this.timePerWeek;}

    public int getTimePerSession(){ return this.timePerSession;}

    public Exercise.Intensity getPreferredIntensity(){return this.preferredIntensity;}

    public String getPreferredWorkoutLocation(){return this.preferredWorkoutLocation;}

    public String getEquipment(){return this.equipment;}




    public void setMedicalHistory(String userMedicalHistory){this.medicalHistory = userMedicalHistory;}

    public void setGoal(String userGoal){this.goal = userGoal;}

    public void setFitnessLevel(UserFitnessLevel userFitnessLevel){this.fitnessLevel = userFitnessLevel;}

    public void setTimePerWeek(int userTimePerWeek){this.timePerWeek = userTimePerWeek;}

    public void setTimePerSession(int userTimePerSession){this.timePerSession = userTimePerSession;}

    public void setPreferredIntensity(Exercise.Intensity userPreferredIntensity){this.preferredIntensity = userPreferredIntensity;}

    public void setPreferredWorkoutLocation(String userPreferredLocation){this.preferredWorkoutLocation = userPreferredLocation;}

}
