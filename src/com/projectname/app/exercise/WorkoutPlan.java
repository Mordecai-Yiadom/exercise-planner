package com.projectname.app.exercise;

import java.util.*;
/* Represents a daily workout regime
 * Encapsulates LinkedList of Exercise objects
 */
public class WorkoutPlan
{
    private LinkedList<Exercise> workOutPlanList;
    private int numOfSets;

    public WorkoutPlan()
    {
        this(1);
    }

    public WorkoutPlan(int numOfSets)
    {
        workOutPlanList = new LinkedList<>();
        this.numOfSets = numOfSets;
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
