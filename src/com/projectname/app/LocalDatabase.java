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
}
