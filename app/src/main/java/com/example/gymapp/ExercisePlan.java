package com.example.gymapp;

import java.util.List;

public class ExercisePlan {
    private String name;
    private String type;
    private String difficulty;
    private String length;
    private String equipment;
    private String progress;
    private List<WorkoutRoutine> workoutRoutines;

    public ExercisePlan(String name, String type, String difficulty, String length, String equipment) {
        this.name = name;
        this.type = type;
        this.difficulty = difficulty;
        this.length = length;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public List<WorkoutRoutine> getWorkoutRoutines() {
        return workoutRoutines;
    }

    public void setWorkoutRoutines(List<WorkoutRoutine> workoutRoutines) {
        this.workoutRoutines = workoutRoutines;
    }
}
