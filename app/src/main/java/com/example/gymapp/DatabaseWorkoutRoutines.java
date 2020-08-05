package com.example.gymapp;

import java.util.ArrayList;
import java.util.List;

public class DatabaseWorkoutRoutines {
    private List<WorkoutRoutine> workoutRoutines = new ArrayList<>();

    public DatabaseWorkoutRoutines(){
        WorkoutRoutine workoutRoutine = new WorkoutRoutine("Chest Day","60 min", "Gym Equipment Required");

        DatabaseExercises databaseExercises = new DatabaseExercises();
        workoutRoutine.setExerciseList(databaseExercises.getExercises());

        workoutRoutines.add(workoutRoutine);
        workoutRoutines.add(new WorkoutRoutine("Leg Day","75 min", "Gym Equipment Required"));
        workoutRoutines.add(new WorkoutRoutine("Back Day", "60 min", "No Equipment Needed"));
    }

    public List<WorkoutRoutine> getWorkoutRoutines() {
        return workoutRoutines;
    }
}
