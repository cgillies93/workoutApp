package com.example.gymapp;

import java.util.List;

public class WorkoutRoutine {
    private String name;
    private String time;
    private String equipment;
    private List<Exercise> exerciseList;

    public WorkoutRoutine(String name, String time, String equipment) {
        this.name = name;
        this.time = time;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}
