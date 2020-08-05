package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class DialogPlanInfo extends AppCompatDialogFragment {
    private View view;
    private String name;
    private String type;
    private String difficulty;
    private String length;
    private String equipment;

    public DialogPlanInfo(String name, String type, String difficulty, String length, String equipment){
        this.name = name;
        this.type = type;
        this.difficulty = difficulty;
        this.length = length;
        this.equipment = equipment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.dialog_plan_details, null);
        initTextViews();
        initRecyclerView();

        Button purchaseButton = (Button)view.findViewById(R.id.buttonStartPlan);
        Button cancel = (Button)view.findViewById(R.id.buttonCancel);

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogStartPlanConfirm dialogStartPlanConfirm = new DialogStartPlanConfirm();
                assert getFragmentManager() != null;
                dialogStartPlanConfirm.show(getFragmentManager(),"start confirm purchase dialog");

            }
        });

        builder.setView(view);


        return builder.create();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private void initTextViews(){
        TextView planName = (TextView)view.findViewById(R.id.infoPlanTitle);
        TextView planType = (TextView)view.findViewById(R.id.infoPlanType);
        TextView planDifficulty = (TextView)view.findViewById(R.id.infoPlanDifficulty);
        TextView planLength = (TextView)view.findViewById(R.id.infoLength);
        TextView planEquipment = (TextView)view.findViewById(R.id.infoEquipment);

        planName.setText(name);
        planType.setText(type);
        planDifficulty.setText(difficulty);
        planLength.setText(length);
        planEquipment.setText(equipment);

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.dialogRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        AdapterPlanInfoDialog adapter = new AdapterPlanInfoDialog(getContext());
        recyclerView.setAdapter(adapter);

    }
}
