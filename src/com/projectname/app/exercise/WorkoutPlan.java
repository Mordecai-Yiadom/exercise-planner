package com.projectname.app.exercise;

import java.util.*;
/* Represents a daily workout regime
 * Encapsulates LinkedList of Exercise objects
 */
public class WorkoutPlan
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

}
