package com.projectname.app.exercise;

//TODO: add hasDistance() + hasDistance
//TODO: get rid of duration in milliseconds comment
public class Exercise
{
    private ExerciseType type;
    private Intensity intensity;

    //Duration is stored in milliseconds
    private long duration;
    private int numOfReps;
    private String name, description;
    private boolean hasReps, hasDuration;

    //Constructors

    /**********************
     * An Exercise can have either numOfReps OR duration not both
     *******************************/
    public Exercise() {}

    public Exercise(ExerciseType type, Intensity intensity, long duration, String name, String description)
    {
        this.type = type;
        this.intensity = intensity;
        setDuration(duration);
        this.name = name;
        this.description = description;
    }


    public Exercise(ExerciseType type, Intensity intensity, int numOfReps, String name, String description)
    {
        this.type = type;
        this.intensity = intensity;
        setNumOfReps(numOfReps);
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

    public void setDuration(long duration)
    {
        this.duration = duration;

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
        hasReps = true;
    }

    public int getNumOfReps()
    {
        if(hasReps) return numOfReps;
        else return -1;
    }
    public boolean hasReps() {return hasReps;}

    public boolean hasDuration() {return hasDuration;}

    public enum Intensity
    {
        LOW,
        MEDIUM,
        HIGH
    }
}
