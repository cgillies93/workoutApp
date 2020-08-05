package com.example.gymapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPlanInfoDialog extends RecyclerView.Adapter<AdapterPlanInfoDialog.MyViewHolder> {
    private Context mContext;

    public AdapterPlanInfoDialog(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_item_plan_info, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String dayNumber = Integer.toString(position + 1);
        holder.dayNumber.setText(dayNumber );
        String name = "Workout Name";
        holder.workoutName.setText(name);

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView workoutName;
        TextView dayTitle;
        TextView dayNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.parentCardView);
            workoutName = (TextView)itemView.findViewById(R.id.planInfoWorkoutName);
            dayTitle = (TextView)itemView.findViewById(R.id.planInfoDayTitle);
            dayNumber = (TextView)itemView.findViewById(R.id.planInfoDayNumber);
        }
    }
}
