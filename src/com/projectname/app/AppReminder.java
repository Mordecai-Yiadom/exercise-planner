package com.projectname.app;

import java.text.DateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class AppReminder {
    private LocalTime time;
    private DayOfWeek day;

    protected AppReminder(LocalTime time, DayOfWeek day) {
        this.time = time;
        this.day = day;
    }

    public LocalTime getTime() {return this.time;}
    public DayOfWeek getDay() {return this.day;}

    public enum Purpose
    {

    }
}
