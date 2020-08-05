package com.example.gymapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentExerciseSlidePage extends Fragment {
    private View view;
    private Exercise exercise;
    private String exerciseNumber;
    private String exerciseTotal;


    public FragmentExerciseSlidePage(){}

    public FragmentExerciseSlidePage(Exercise exercise, String exerciseNumber){
        this.exercise = exercise;
        this.exerciseNumber = exerciseNumber;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = (ViewGroup)inflater.inflate(R.layout.view_pager_exercise_slide_page, container, false);
        initTextViews();
        TableLayout tableLayout = (TableLayout)view.findViewById(R.id.exerciseTableLayout);

        for (int i = 0; i < 5;i++) {
            View view1 = (ViewGroup) inflater.inflate(R.layout.exercise_table_layout_row, container, false);
            TextView setNumber = (TextView)view1.findViewById(R.id.tableNumberSets);
            String set = Integer.toString(i + 1);
            setNumber.setText(set);
            tableLayout.addView(view1);
        }

        return view;
    }

    private void initTextViews(){
        TextView exerciseName = (TextView)view.findViewById(R.id.exerciseName);
        TextView exerciseType = (TextView)view.findViewById(R.id.exerciseType);
        TextView exerciseTotal = (TextView)view.findViewById(R.id.exercisesTotal);
        TextView exerciseNumber = (TextView)view.findViewById(R.id.exerciseNumber);
        TextView exerciseDescription = (TextView)view.findViewById(R.id.exerciseDescription);

        exerciseName.setText(exercise.getName());
        exerciseType.setText(exercise.getType());
    }
}
