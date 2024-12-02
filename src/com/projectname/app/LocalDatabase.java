package com.projectname.app;

import com.projectname.app.exercise.*;
import java.util.Hashtable;

public class LocalDatabase
{
    private Hashtable<ExerciseType, Exercise> EXERCISE_DATATABLE;

    protected LocalDatabase()
    {
        EXERCISE_DATATABLE = new Hashtable();
        loadWorkoutPlans();
        loadExercises();
    }

    protected void loadWorkoutPlans()
    {}

    protected void loadExercises()
    {
    }
}
