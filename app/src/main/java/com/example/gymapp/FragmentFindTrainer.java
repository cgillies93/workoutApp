package com.example.gymapp;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;


public class FragmentFindTrainer extends Fragment {
    private View view;

    public FragmentFindTrainer() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find_trainer, container, false);
        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.findTrainerRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        DatabaseTrainers db = new DatabaseTrainers();
        List<Trainer> trainers = db.getTrainers();

        AdapterTrainerList adapter = new AdapterTrainerList(getContext(), trainers);
        recyclerView.setAdapter(adapter);

    }

}
