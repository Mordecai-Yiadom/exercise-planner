package com.projectname.app;

import java.util.*;

public class ReminderManager
{
    private Thread REMINDER_THREAD;

    LinkedList<AppReminder> CURRENT_REMINDERS;

    protected ReminderManager()
    {
        REMINDER_THREAD = new Thread();
        CURRENT_REMINDERS = new LinkedList<>();
    }

    public AppReminder pushReminder(AppReminder reminder)
    {
        CURRENT_REMINDERS.remove(reminder);
        return reminder;
    }

}
