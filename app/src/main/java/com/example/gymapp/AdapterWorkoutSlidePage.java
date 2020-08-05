package com.example.gymapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

public class AdapterWorkoutSlidePage extends FragmentStateAdapter{
    private List<WorkoutRoutine> workoutRoutines;

    public AdapterWorkoutSlidePage(@NonNull FragmentActivity fragmentActivity, List<WorkoutRoutine> workoutRoutines) {
        super(fragmentActivity);
        this.workoutRoutines = workoutRoutines;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        WorkoutRoutine workoutRoutine = workoutRoutines.get(position);
        String dayNumber = Integer.toString(position + 1);
        return new FragmentWorkoutSlidePage(workoutRoutine, dayNumber);
    }

    @Override
    public int getItemCount() {
        return workoutRoutines.size();
    }
}
