package com.example.gymapp;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.List;

public class ActivityCurrentWorkout extends FragmentActivity {
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_workout);
        setupViewPager();
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private void setupViewPager(){
        DatabaseExercises exercises = new DatabaseExercises();
        List<Exercise> exerciseList = exercises.getExercises();
        viewPager = findViewById(R.id.viewPager);
        AdapterExerciseSlidePager pagerAdapter = new AdapterExerciseSlidePager(this, exerciseList);
        viewPager.setAdapter(pagerAdapter);
    }
}
