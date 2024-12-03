package com.projectname.app;

import com.projectname.app.exercise.*;
import java.io.Serializable;
import java.util.*;

public class LocalDatabase implements Serializable
{
    private Hashtable<ExerciseType, Exercise> EXERCISE_DATATABLE;
    private ArrayList<WorkoutPlan> WORKOUT_PLAN_DATA_LIST;

    protected LocalDatabase()
    {
        EXERCISE_DATATABLE = new Hashtable();
        WORKOUT_PLAN_DATA_LIST = new ArrayList<>();
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
        if(workoutPlan != null) return WORKOUT_PLAN_DATA_LIST.add(workoutPlan);
        return false;
    }

    public boolean removeWorkoutPlan(WorkoutPlan workoutPlan)
    {
        if(workoutPlan != null) return WORKOUT_PLAN_DATA_LIST.remove(workoutPlan);
        return false;
    }

    public int exerciseDatatableSize() {return EXERCISE_DATATABLE.size();}

    public int workoutPlanDataListSize() {return WORKOUT_PLAN_DATA_LIST.size();}
}
