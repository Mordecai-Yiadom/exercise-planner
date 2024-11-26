package com.projectname.app.exercise;

import java.util.*;
/* Represents a daily workout regime
 * Encapsulates LinkedList of Exercise objects
 */
public class WorkoutPlan
{
    private LinkedList<Exercise> workOutPlanList;

    public WorkoutPlan()
    {
        workOutPlanList = new LinkedList<>();
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

}
