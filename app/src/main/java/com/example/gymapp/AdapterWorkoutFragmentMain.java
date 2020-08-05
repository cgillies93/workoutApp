package com.example.gymapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterWorkoutFragmentMain extends RecyclerView.Adapter<AdapterWorkoutFragmentMain.MyViewHolder> {
    private Context mContext;
    private List<ExercisePlan> plans;
    private WorkoutFragmentMainOnClickHandler mOnClickHandler;

    public AdapterWorkoutFragmentMain(Context mContext, List<ExercisePlan> plans, WorkoutFragmentMainOnClickHandler mOnClickHandler){
        this.mContext = mContext;
        this.plans = plans;
        this.mOnClickHandler = mOnClickHandler;
    }

    public interface WorkoutFragmentMainOnClickHandler{
        void onClick(String planInfo);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_item_my_plans, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExercisePlan plan = plans.get(position);
        holder.planName.setText(plan.getName());
        holder.planType.setText(plan.getType());
        holder.planDifficulty.setText(plan.getDifficulty());
        holder.planLength.setText(plan.getLength());
        holder.planEquipment.setText(plan.getEquipment());
        if (plan.getProgress() != null) {
            holder.progress.setText(plan.getProgress());
        } else {
            holder.continuePlan.setText(R.string.button_start_plan);
            holder.progress.setText("0");
        }
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView planName;
        TextView planType;
        TextView planDifficulty;
        TextView planLength;
        TextView planEquipment;
        TextView progress;
        TextView percentageSign;
        TextView completedTitle;
        Button continuePlan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            planName = (TextView)itemView.findViewById(R.id.myPlansName);
            planType = (TextView)itemView.findViewById(R.id.myPlansType);
            planDifficulty = (TextView)itemView.findViewById(R.id.myPlansDifficulty);
            planLength = (TextView)itemView.findViewById(R.id.myPlansLength);
            planEquipment = (TextView)itemView.findViewById(R.id.myPlansEquipment);
            progress = (TextView)itemView.findViewById(R.id.myPlansProgress);
            percentageSign = (TextView)itemView.findViewById(R.id.myPlansPercentageSign);
            completedTitle = (TextView)itemView.findViewById(R.id.myPlansCompletedTitle);
            continuePlan = (Button)itemView.findViewById(R.id.buttonContinuePlan);

            continuePlan.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String name = planName.getText().toString();
            mOnClickHandler.onClick(name);

        }
    }
}
