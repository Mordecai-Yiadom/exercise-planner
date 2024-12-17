package com.projectname.app;

import com.projectname.app.ui.AppUIManager;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

public class ReminderManager implements Runnable, Serializable
{
    private static Thread REMINDER_THREAD;
    private LinkedList<AppReminder> CURRENT_REMINDERS;

    protected ReminderManager()
    {
        CURRENT_REMINDERS = new LinkedList<>();

        REMINDER_THREAD.start();
        System.out.println("Reminder Thread Has Started");
    }

    public AppReminder pushReminder(AppReminder reminder)
    {
        removeReminder(reminder);
        AppUIManager.launchReminder(reminder);
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

    protected static Thread init()
    {
        REMINDER_THREAD = new Thread(Application.instance().getReminderManager());
        REMINDER_THREAD.start();
        return REMINDER_THREAD;
    }


    //Runs once every minute from Application Launch
    @Override
    public void run()
    {
        while(Application.isRunning())
        {
            LinkedList<AppReminder> reminders = (LinkedList<AppReminder>) CURRENT_REMINDERS.clone();
            for(AppReminder reminder : reminders)
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
