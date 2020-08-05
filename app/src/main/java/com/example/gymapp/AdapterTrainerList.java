package com.example.gymapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterTrainerList extends RecyclerView.Adapter<AdapterTrainerList.MyViewHolder> {
    private Context mContext;
    private List<Trainer> trainers;


    public AdapterTrainerList(Context mContext, List<Trainer> trainers){
        this.mContext = mContext;
        this.trainers = trainers;

    }

    @NonNull
    @Override
    public AdapterTrainerList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_item_trainer_card_, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTrainerList.MyViewHolder holder, int position) {
        Trainer trainer = trainers.get(position);
        holder.firstName.setText(trainer.getFirstName());
        holder.lastName.setText(trainer.getLastName());
        holder.certifications.setText(trainer.getCertifications());
        holder.bio.setText(trainer.getBio());


    }

    @Override
    public int getItemCount() {
        return trainers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstName;
        TextView lastName;
        ImageView image;
        TextView certifications;
        TextView bio;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = (TextView)itemView.findViewById(R.id.trainerFirstName);
            lastName = (TextView)itemView.findViewById(R.id.trainerLastName);
            image = (ImageView)itemView.findViewById(R.id.trainerImage);
            certifications = (TextView)itemView.findViewById(R.id.trainerCertifications);
            bio = (TextView)itemView.findViewById(R.id.trainerBio);
        }
    }
}
