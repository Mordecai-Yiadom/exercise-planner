package com.projectname.app;

import com.projectname.app.exercise.*;
import java.io.Serializable;
import java.util.*;

public class LocalDatabase implements Serializable
{
    private Hashtable<ExerciseType, Exercise> EXERCISE_DATATABLE;
    private HashSet<WorkoutPlan> WORKOUT_PLAN_DATA_SET;

    protected LocalDatabase()
    {
        EXERCISE_DATATABLE = new Hashtable();
        WORKOUT_PLAN_DATA_SET = new HashSet<>();
    }

    public boolean addExercise(Exercise exercise)
    {
        if(exercise != null)
        {
            EXERCISE_DATATABLE.put(exercise.getType(), exercise);
            return true;
        }
        return false;
    }

    public boolean removeExercise(Exercise exercise)
    {
        if(exercise != null)
        {
            EXERCISE_DATATABLE.remove(exercise.getType(), exercise);
            return true;
        }
        return false;
    }

    public boolean addWorkoutPlan(WorkoutPlan workoutPlan)
    {
        if(workoutPlan != null) return WORKOUT_PLAN_DATA_SET.add(workoutPlan);
        return false;
    }

    public boolean removeWorkoutPlan(WorkoutPlan workoutPlan)
    {
        if(workoutPlan != null) return WORKOUT_PLAN_DATA_SET.remove(workoutPlan);
        return false;
    }

    public Set<Exercise> getExercises(ExerciseType type)
    {
        Set<Exercise> exerciseSet = new HashSet<>();
        for(Exercise exercise : EXERCISE_DATATABLE.values())
            if(exercise.getType().equals(type)) exerciseSet.add(exercise);

        return exerciseSet;
    }

    public Set<Exercise> getExercises()
    {
        return (Set<Exercise>) EXERCISE_DATATABLE.values();
    }

    public Set<WorkoutPlan> getWorkoutPlans()
    {
        try {return (Set<WorkoutPlan>) WORKOUT_PLAN_DATA_SET.clone();}
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public int exerciseDatatableSize() {return EXERCISE_DATATABLE.size();}

    public int workoutPlanDataListSize() {return WORKOUT_PLAN_DATA_SET.size();}
}
