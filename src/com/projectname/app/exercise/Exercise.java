package com.projectname.app.exercise;

import com.projectname.app.exercise.ExerciseType;

public class Exercise
{
    private ExerciseType type;
    private Intensity intensity;
    private long duration;
    private String name, description;

    public Exercise()
    {}

    public Exercise(ExerciseType type, Intensity intensity, long duration, String name, String description)
    {
        this.type = type;
        this.intensity = intensity;
        this.duration = duration;
        this.name = name;
        this.description = description;
    }

    public String toCSV() {
        return String.join("," + name + type + intensity + String.valueOf(duration) + description);
    }

    public static Exercise fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Exercise(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription() {return description;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public void setType(ExerciseType type) {this.type = type;}

    public ExerciseType getType() {return type;}

    public void setIntensity(Intensity intensity) {this.intensity = intensity;}

    public Intensity getIntensity() {return intensity;}

    public void setDuration(long duration){this.duration = duration;}

    public long getDuration() {return duration;}

    public enum Intensity
    {
        LOW,
        MEDIUM,
        CUSTOM
    }
}
