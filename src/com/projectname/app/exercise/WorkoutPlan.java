package com.projectname.app.exercise;

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

    public static WorkoutPlan RandomPlan (UserFitnessLevel userLevel){
        WorkoutPlan plan = new WorkoutPlan();

        switch (userLevel){

            case BEGINNER:
                plan.setNumOfSets(3);
                break;

            case INTERMEDIATE:
                plan.setNumOfSets(5);
                break;

            case ADVANCED:
                plan.setNumOfSets(7);
                break;

            default:
                break;

        }

        Random rand = new Random();
        int [] randomNumbers = new int[3];
        randomPlanList = new LinkedList<>();
        for(int i = 0; i < 3; i++) {
            randomNumbers [x] = rand (workoutPlanDataListSize());
        }

        return plan;
    }

    public WorkoutPlan(String name, int numOfSets)
    {
        workOutPlanList = new LinkedList<>();
        this.numOfSets = numOfSets;
        this.name = name;
    }


    public boolean addExercise(Exercise exercise)
    {
        return workOutPlanList.add(exercise);
    }


    public boolean removeExercise(Exercise exercise)
    {
        return workOutPlanList.remove(exercise);
    }

    public boolean containsExercise(Exercise exercise)
    {
        return workOutPlanList.contains(exercise);
    }

    public void setNumOfSets(int numOfSets)
    {
        if(numOfSets < 1)
            this.numOfSets = 1;
        else
            this.numOfSets = numOfSets;
    }

    public int getNumOfSets() {return numOfSets;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

}
