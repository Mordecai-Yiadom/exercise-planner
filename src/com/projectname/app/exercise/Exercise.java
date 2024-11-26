package com.projectname.app.exercise;

public class Exercise
{
    private ExerciseType type;
    private Intensity intensity;

    //Duration is stored in milliseconds
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
        HIGH
    }
}
