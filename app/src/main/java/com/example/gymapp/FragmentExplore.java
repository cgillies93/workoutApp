package com.example.gymapp;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class FragmentExplore extends Fragment implements AdapterExploreFragment.ExploreFragmentAdapterOnClickHandler {
    private View view;
    private ExercisePlan plan;


    public FragmentExplore() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_explore, container, false);
        initRecyclerView();

        return view;
    }

    @Override
    public void onClick(String planName) {
        findExercisePlan(planName);
        DialogPlanInfo dialog = new DialogPlanInfo(plan.getName(),plan.getType(),plan.getDifficulty()
                ,plan.getLength(), plan.getEquipment());

        assert getFragmentManager() != null;
        dialog.show(getFragmentManager(), "show workout plan info");
    }

    public void initRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.explore_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        DatabaseExercisePlans dbExercisePlans = new DatabaseExercisePlans();
        List<ExercisePlan> exercisePlans = dbExercisePlans.getExercisePlans();

        AdapterExploreFragment adapter = new AdapterExploreFragment(getContext(), exercisePlans, this);
        recyclerView.setAdapter(adapter);
    }

    public boolean findExercisePlan(String planName){
        if (planName != null){
            DatabaseExercisePlans plans = new DatabaseExercisePlans();
            this.plan = plans.findPlan(planName);
            return true;
        }
        return false;
    }
}
