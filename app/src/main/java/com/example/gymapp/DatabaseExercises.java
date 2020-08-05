package com.example.gymapp;

import java.util.ArrayList;
import java.util.List;

public class DatabaseExercises {
    List<Exercise> exercises = new ArrayList<>();

    public DatabaseExercises(){
        exercises.add(new Exercise("Bench Press","Chest"));
        exercises.add(new Exercise("Military Press", "Shoulders"));
        exercises.add(new Exercise("Squat", "Legs"));
        exercises.add(new Exercise("Barbell Curls","Biceps"));
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}
