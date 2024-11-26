package com.projectname.app.exercise;

public class CustomExerciseType
{
    private String typeName;

    public CustomExerciseType(String typeName)
    {
        this.typeName = typeName;
    }

    @Override
    public String toString()
    {
        return typeName.toUpperCase();
    }
}
