package com.example.gymapp;

import java.util.ArrayList;
import java.util.List;

public class DatabaseExercisePlans {
    private List<ExercisePlan> exercisePlans = new ArrayList<>();

    public DatabaseExercisePlans(){
        ExercisePlan plan = new ExercisePlan("Maximum Muscle", "Build Muscle", "Advanced",
                "9 Weeks", "Full Gym");
        plan.setProgress("67");

        DatabaseWorkoutRoutines workoutRoutines = new DatabaseWorkoutRoutines();
        plan.setWorkoutRoutines(workoutRoutines.getWorkoutRoutines());


        exercisePlans.add(plan);
        exercisePlans.add(new ExercisePlan("Keto Muscle", "Build Muscle", "Intermediate",
                "4 weeks","Full Gym"));
        exercisePlans.add(new ExercisePlan("Live Fit","Lose Weight","Intermediate",
                "12 Weeks","Full Gym"));

    }

    public List<ExercisePlan> getExercisePlans() {
        return exercisePlans;
    }

    public ExercisePlan findPlan(String name){
        if (name != null){
            for (int i = 0; i < exercisePlans.size(); i++){
                ExercisePlan checkPlan = exercisePlans.get(i);
                if (checkPlan.getName().equals(name)){
                    return checkPlan;
                }
            }
        }
        return null;
    }

}
