package com.projectname.app;


import com.projectname.app.exercise.WorkoutPlan;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class Schedule implements Serializable
{
    //TODO make localdatetime
    public static final DayOfWeek START_OF_WEEK = DayOfWeek.SUNDAY;

    private HashMap<DayOfWeek, WorkoutPlan> SCHEDULE_WORKOUT_PLAN_TABLE;
    private HashMap<DayOfWeek, LocalDateTime> SCHEDULE_DATETIME_TABLE;

    protected Schedule()
    {
        SCHEDULE_WORKOUT_PLAN_TABLE = new HashMap<>();
        SCHEDULE_DATETIME_TABLE = new HashMap<>();
        for(DayOfWeek day : DayOfWeek.class.getEnumConstants())
        {
            SCHEDULE_WORKOUT_PLAN_TABLE.put(day, null);
            SCHEDULE_DATETIME_TABLE.put(day, null);
        }
    }

    public WorkoutPlan getWorkoutPlan(DayOfWeek day)
    {
        return SCHEDULE_WORKOUT_PLAN_TABLE.get(day);
    }

}
