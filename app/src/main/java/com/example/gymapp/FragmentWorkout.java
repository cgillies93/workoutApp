package com.example.gymapp;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;


public class FragmentWorkout extends Fragment implements AdapterWorkoutFragmentMain.WorkoutFragmentMainOnClickHandler {
    private View view;

    public FragmentWorkout() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_workout_main, container, false);
        initRecyclerView();

        return view;
    }

    @Override
    public void onClick(String planInfo) {
        Intent intent = new Intent(getContext(), ActivityCurrentWorkoutList.class);
        startActivity(intent);
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.myPlansRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        DatabaseExercisePlans dbExercisePlans = new DatabaseExercisePlans();
        List<ExercisePlan> exercisePlans = dbExercisePlans.getExercisePlans();

        AdapterWorkoutFragmentMain adapter = new AdapterWorkoutFragmentMain(getContext(), exercisePlans, this);
        recyclerView.setAdapter(adapter);
    }
}
