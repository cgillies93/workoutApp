package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWorkoutSlidePage extends Fragment {
    private View view;
    private WorkoutRoutine workoutRoutine;
    private String dayNumber;

    public FragmentWorkoutSlidePage(){

    }

    public FragmentWorkoutSlidePage(WorkoutRoutine workoutRoutine, String dayNumber){
        this.workoutRoutine = workoutRoutine;
        this.dayNumber = dayNumber;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = (ViewGroup)inflater.inflate(R.layout.view_pager_workout_slide_page, container, false);

        initTextViews();

        Button beginWorkout = (Button)view.findViewById(R.id.buttonBeginWorkout);
        beginWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityCurrentWorkout.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void initTextViews(){
        TextView workoutName = (TextView) view.findViewById(R.id.workoutName);
        TextView workoutType = (TextView) view.findViewById(R.id.workoutType);
        TextView workoutTime = (TextView) view.findViewById(R.id.workoutTime);
        TextView workoutEquipment = (TextView) view.findViewById(R.id.workoutEquipment);
        TextView workoutDayNumber = (TextView) view.findViewById(R.id.workoutDayNumber);

        workoutName.setText(workoutRoutine.getName());
        workoutTime.setText(workoutRoutine.getTime());
        workoutEquipment.setText(workoutRoutine.getEquipment());
        workoutDayNumber.setText(dayNumber);

    }

}
