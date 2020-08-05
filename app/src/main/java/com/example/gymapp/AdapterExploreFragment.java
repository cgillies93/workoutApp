package com.example.gymapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterExploreFragment extends RecyclerView.Adapter<AdapterExploreFragment.MyViewHolder> {
    private Context mContext;
    private List<ExercisePlan> exercisePlans;
    private ExploreFragmentAdapterOnClickHandler mClickHandler;

    public AdapterExploreFragment(Context mContext, List<ExercisePlan> exercisePlans,
                                  ExploreFragmentAdapterOnClickHandler mClickHandler){
        this.mContext = mContext;
        this.exercisePlans = exercisePlans;
        this.mClickHandler = mClickHandler;
    }

    public interface ExploreFragmentAdapterOnClickHandler{
        void onClick(String planInfo);
    }


    @NonNull
    @Override
    public AdapterExploreFragment.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_item_explore_plans, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExploreFragment.MyViewHolder holder, int position) {
        ExercisePlan exercisePlan = exercisePlans.get(position);
        holder.planName.setText(exercisePlan.getName());
        holder.planType.setText(exercisePlan.getType());
        holder.planDifficulty.setText(exercisePlan.getDifficulty());
        holder.planLength.setText(exercisePlan.getLength());
        holder.planEquipment.setText(exercisePlan.getEquipment());

    }

    @Override
    public int getItemCount() {
        return exercisePlans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ConstraintLayout constraintLayout;
        TextView planName;
        TextView planType;
        TextView planDifficulty;
        TextView planLength;
        TextView planEquipment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            constraintLayout = (ConstraintLayout)itemView.findViewById(R.id.constrain_layout);
            planName = (TextView)itemView.findViewById(R.id.planTitle);
            planType = (TextView)itemView.findViewById(R.id.planType);
            planDifficulty = (TextView)itemView.findViewById(R.id.planDifficulty);
            planLength = (TextView)itemView.findViewById(R.id.planLength);
            planEquipment = (TextView)itemView.findViewById(R.id.planEquipment);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String name = planName.getText().toString();
            mClickHandler.onClick(name);

        }
    }
}
