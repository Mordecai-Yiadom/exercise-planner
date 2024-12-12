package com.projectname.app;

import com.projectname.app.exercise.*;
import java.io.Serializable;
import java.util.*;

public class LocalDatabase implements Serializable
{
    private Hashtable<ExerciseType, LinkedList<Exercise>> EXERCISE_DATATABLE;
    private Set<WorkoutPlan> WORKOUT_PLAN_DATA_SET;
    private Set<ExerciseType> EXERCISE_TYPES_SET;

    protected LocalDatabase()
    {
        EXERCISE_DATATABLE = new Hashtable<>();
        WORKOUT_PLAN_DATA_SET = new HashSet<>();
        EXERCISE_TYPES_SET = new HashSet<>();

        //Add default exercise types
        for(DefaultExerciseType type : DefaultExerciseType.class.getEnumConstants())
        {
            EXERCISE_TYPES_SET.add(type);
            EXERCISE_DATATABLE.put(type, new LinkedList<>());
            System.out.println(type + " has been added");
        }
    }

    public boolean addExercise(Exercise exercise)
    {
        if(exercise != null)
        {
            EXERCISE_DATATABLE.get(exercise.getType()).add(exercise);
            return true;
        }
        return false;
    }

    public boolean removeExercise(Exercise exercise)
    {
        if(exercise != null)
        {
            EXERCISE_DATATABLE.get(exercise.getType()).remove(exercise);
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

    public Collection<Exercise> getExercises(ExerciseType type)
    {
        return EXERCISE_DATATABLE.get(type);
    }

    public Collection<Exercise> getExercises()
    {
        Collection<Exercise> allExercises = new LinkedList<>();
        for(ExerciseType type : EXERCISE_TYPES_SET)
        {
            try{allExercises.addAll(EXERCISE_DATATABLE.get(type));}
            catch(Exception ex){ex.printStackTrace();}
        }
        return allExercises;
    }

    //UNSAFE TODO update this to be safer
    public Collection<WorkoutPlan> getWorkoutPlans()
    {
        return WORKOUT_PLAN_DATA_SET;
    }

    public boolean addCustomExerciseType(CustomExerciseType customExerciseType)
    {
        if(EXERCISE_TYPES_SET.add(customExerciseType))
        {
            EXERCISE_DATATABLE.remove(customExerciseType);
            return true;
        }
        return false;
    }

    public boolean removeCustomExerciseType(CustomExerciseType customExerciseType)
    {
        return EXERCISE_TYPES_SET.remove(customExerciseType);
    }

    public int exerciseDatatableSize() {return EXERCISE_DATATABLE.size();}

    public int workoutPlanDataListSize() {return WORKOUT_PLAN_DATA_SET.size();}
}
