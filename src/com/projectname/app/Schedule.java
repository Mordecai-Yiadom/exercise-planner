package com.projectname.app;


import com.projectname.app.exercise.WorkoutPlan;

import java.io.Serializable;
import java.time.*;
import java.util.HashMap;

public class Schedule implements Serializable
{
    private final HashMap<DayOfWeek, WorkoutPlan> SCHEDULE_WORKOUT_PLAN_TABLE;
    private final HashMap<DayOfWeek, LocalTime> SCHEDULE_TIME_TABLE;

    protected Schedule()
    {
        SCHEDULE_WORKOUT_PLAN_TABLE = new HashMap<>();
        SCHEDULE_TIME_TABLE = new HashMap<>();
        for(DayOfWeek day : DayOfWeek.class.getEnumConstants())
        {
            SCHEDULE_WORKOUT_PLAN_TABLE.put(day, null);
            SCHEDULE_TIME_TABLE.put(day, null);
        }
    }

    public WorkoutPlan getWorkoutPlan(DayOfWeek day)
    {
        return SCHEDULE_WORKOUT_PLAN_TABLE.get(day);
    }

    public LocalTime getScheduledTime(DayOfWeek day)
    {
        return SCHEDULE_TIME_TABLE.get(day);
    }

    public void scheduleWorkoutPlan(DayOfWeek day, LocalTime time, WorkoutPlan workoutPlan)
    {
        SCHEDULE_WORKOUT_PLAN_TABLE.replace(day, workoutPlan);
        SCHEDULE_TIME_TABLE.replace(day, time);

        if(time != null || workoutPlan != null)
        {
            ReminderManager reminderManager = Application.instance().getReminderManager();
            reminderManager.addReminder(new AppReminder(time, day));
        }

        Application.instance().saveLocalDatabase();
        Application.instance().saveUserSchedule();
    }
}
