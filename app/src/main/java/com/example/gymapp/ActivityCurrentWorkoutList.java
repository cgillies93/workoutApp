package com.example.gymapp;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

public class ActivityCurrentWorkoutList extends FragmentActivity {
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        DatabaseWorkoutRoutines routines = new DatabaseWorkoutRoutines();
        List<WorkoutRoutine> routineList = routines.getWorkoutRoutines();
        viewPager = findViewById(R.id.viewPager);
        AdapterWorkoutSlidePage adapter = new AdapterWorkoutSlidePage(this, routineList);
        viewPager.setAdapter(adapter);
    }
}
