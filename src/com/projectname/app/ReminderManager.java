package com.projectname.app;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

public class ReminderManager implements Runnable, Serializable
{
    private transient Thread REMINDER_THREAD;
    private LinkedList<AppReminder> CURRENT_REMINDERS;

    protected ReminderManager()
    {
        REMINDER_THREAD = new Thread(this);
        CURRENT_REMINDERS = new LinkedList<>();
    }

    public AppReminder pushReminder(AppReminder reminder)
    {
        removeReminder(reminder);
        return reminder;
    }

    public void addReminder(AppReminder reminder)
    {
        if(CURRENT_REMINDERS.contains(reminder)) CURRENT_REMINDERS.add(reminder);
    }

    public void removeReminder(AppReminder reminder)
    {
        if(CURRENT_REMINDERS.contains(reminder)) CURRENT_REMINDERS.remove(reminder);
    }

    //Runs once every minute from Application Launch
    @Override
    public void run()
    {
        while(true)
        {
            for(AppReminder reminder : CURRENT_REMINDERS)
            {
               LocalDateTime currentTime = LocalDateTime.now();
               DayOfWeek currentDay = currentTime.getDayOfWeek();
               if(currentDay.equals(reminder.getDay()))
               {
                   int currentHour = currentTime.getHour();
                   int currentMinute = currentTime.getMinute();

                   if(currentHour == reminder.getTime().getHour() && currentMinute == reminder.getTime().getMinute())
                       pushReminder(reminder);
               }
            }

            try {Thread.sleep(60_000);}
            catch(Exception ex) {ex.printStackTrace();}
        }
    }
}
