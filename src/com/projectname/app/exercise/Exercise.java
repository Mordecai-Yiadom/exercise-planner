package com.projectname.app.exercise;

import java.io.Serializable;

public class Exercise implements Serializable
{
    private ExerciseType type;
    private Intensity intensity;

    //Duration is stored in seconds
    //Distance is in miles

    private long duration;
    private int numOfReps;
    private float distance;
    private String name, description;
    private boolean hasReps, hasDuration, hasDistance;

    //Constructors
    public Exercise() {}

    public Exercise(ExerciseType type, Intensity intensity, long duration, String name, String description)
    {
        setType(type);
        this.intensity = intensity;
        setDuration(duration);
        this.name = name;
        this.description = description;
    }


    public Exercise(ExerciseType type, Intensity intensity, int numOfReps, String name, String description)
    {
        setType(type);
        this.intensity = intensity;
        setNumOfReps(numOfReps);
        this.name = name;
        this.description = description;
    }

    public Exercise(ExerciseType type, Intensity intensity, float distance, String name, String description)
    {
        setType(type);
        this.intensity = intensity;
        setDistance(distance);
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

    public void setType(ExerciseType type)
    {
        if(type == null) this.type = DefaultExerciseType.UNKNOWN;
        else this.type = type;
    }

    public ExerciseType getType() {return type;}

    public void setIntensity(Intensity intensity) {this.intensity = intensity;}

    public Intensity getIntensity() {return intensity;}

    public void setDuration(long duration)
    {
        this.duration = duration;

        hasDistance = false;
        hasReps = false;
        hasDuration = true;
    }

    public long getDuration()
    {
        if(hasDuration) return duration;
        else return -1;
    }

    public void setNumOfReps(int numOfReps)
    {
        this.numOfReps = numOfReps;

        hasDuration = false;
        hasDistance = false;
        hasReps = true;
    }

    public void setDistance(float distance)
    {
        this.distance = distance;

        hasDuration = false;
        hasReps = false;
        hasDistance =  true;
    }

    public int getNumOfReps()
    {
        if(hasReps) return numOfReps;
        else return -1;
    }

    public float getDistance()
    {
        if(hasDistance) return distance;
        else return -1;
    }

    public boolean hasReps() {return hasReps;}

    public boolean hasDuration() {return hasDuration;}

    public boolean hasDistance() {return hasDistance;}

    public enum Intensity implements Serializable
    {
        LOW,
        MEDIUM,
        HIGH
    }
}
