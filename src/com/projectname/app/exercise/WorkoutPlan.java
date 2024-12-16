package com.projectname.app.exercise;

import com.projectname.app.Application;
import com.projectname.app.LocalDatabase;
import com.projectname.app.user.UserFitnessLevel;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.*;
import java.util.Random;

import static com.projectname.app.user.UserFitnessLevel.*;

/* Represents a daily workout regime
 * Encapsulates LinkedList of Exercise objects
 */
public class WorkoutPlan implements Serializable
{

    private LinkedList<Exercise> workOutPlanList;

    private String name;
    private int numOfSets;

    public WorkoutPlan()
    {
        this(null,1);
    }

    public WorkoutPlan(String name)
    {
        this(name, 1);
    }


    public WorkoutPlan(String name, int numOfSets)
    {
        workOutPlanList = new LinkedList<>();
        setNumOfSets(numOfSets);
        this.name = name;
    }

    public static WorkoutPlan createRandomPlan (UserFitnessLevel userLevel)
    {
        WorkoutPlan plan = new WorkoutPlan("Random Plan");
        LocalDatabase localDatabase = Application.instance().getLocalDatabase();
        Exercise[] allExercises = localDatabase.getExercises().toArray(new Exercise[0]);
        int numOfExercises = 4;

        switch (userLevel){

            case BEGINNER:
                plan.setNumOfSets(3);
                numOfExercises = 3;
                break;

            case INTERMEDIATE:
                plan.setNumOfSets(5);
                numOfExercises = 5;
                break;

            case ADVANCED:
                plan.setNumOfSets(7);
                numOfExercises = 7;
                break;
        }

        for(int i = 0; i < numOfExercises; i++)
        {
            plan.addExercise(allExercises[(int)(Math.random() * localDatabase.workoutPlanDataListSize())]);
        }

        return plan;
    }

    public boolean addExercise(Exercise exercise)
    {
        return workOutPlanList.add(exercise);
    }

    public void addExercise(Collection<Exercise> exercises)
    {
        for(Exercise exercise : exercises) addExercise(exercise);
    }

    public boolean removeExercise(Exercise exercise)
    {
        return workOutPlanList.remove(exercise);
    }

    public boolean containsExercise(Exercise exercise)
    {
        return workOutPlanList.contains(exercise);
    }

    //TODO FIX ME: Dangerous Accessor Method
    public Collection<Exercise> getExercises(){return workOutPlanList;}

    public void setNumOfSets(int numOfSets)
    {
        if(numOfSets < 1) this.numOfSets = 1;
        else this.numOfSets = numOfSets;
    }

    public int getNumOfSets() {return numOfSets;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    @Override
    public String toString()
    {
        return this.name;
    }
}
