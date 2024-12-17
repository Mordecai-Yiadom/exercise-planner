package com.projectname.app;

import com.projectname.app.ui.AppUIManager;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

public class ReminderManager implements Runnable, Serializable
{
    private LinkedList<AppReminder> CURRENT_REMINDERS;

    protected ReminderManager()
    {
        CURRENT_REMINDERS = new LinkedList<>();
        System.out.println("Reminder Thread Has Started");
    }

    public AppReminder pushReminder(AppReminder reminder)
    {
        AppUIManager.launchReminder(reminder);
        return reminder;
    }

    public void addReminder(AppReminder reminder)
    {
        CURRENT_REMINDERS.add(reminder);
    }

    public void removeReminder(AppReminder reminder)
    {
        CURRENT_REMINDERS.remove(reminder);
    }

    //Runs once every minute from Application Launch
    @Override
    public void run()
    {
        System.out.println("Started THread");
        while(Application.isRunning())
        {
            //LinkedList<AppReminder> reminders = (LinkedList<AppReminder>) CURRENT_REMINDERS.clone();
            for(AppReminder reminder : CURRENT_REMINDERS)
            {
                if(reminder == null) continue;
                System.out.println("Checked!");
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
