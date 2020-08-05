package com.example.gymapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

public class AdapterExerciseSlidePager extends FragmentStateAdapter {
    private List<Exercise> exercises;


    public AdapterExerciseSlidePager(@NonNull FragmentActivity fragmentActivity, List<Exercise> exercises) {
        super(fragmentActivity);
        this.exercises = exercises;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Exercise exercise = exercises.get(position);
        String exerciseNumber = Integer.toString(position + 1);
        return new FragmentExerciseSlidePage(exercise, exerciseNumber);
    }


    @Override
    public int getItemCount() {
        return exercises.size();
    }

}

