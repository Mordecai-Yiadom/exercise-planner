package com.projectname.app;

import java.text.DateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class AppReminder {
    private LocalDateTime dateTime;

    protected AppReminder(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {return this.dateTime;}

    public enum Purpose
    {

    }
}
