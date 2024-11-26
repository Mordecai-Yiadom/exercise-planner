package com.projectname.app.exercise;

import com.projectname.app.exercise.ExerciseType;

public class Exercise
{
    private ExerciseType type;
    private String name, description;

    public Exercise(ExerciseType type, String name, String description)
    {
        this.type = type;
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
}
