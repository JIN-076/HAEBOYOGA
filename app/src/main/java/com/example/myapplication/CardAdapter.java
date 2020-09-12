package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Training;

import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.TrainingHolder>
                            implements OnItemClickListener {

    private Context context;
    private ArrayList<Training> trainings;
    OnItemClickListener listener;

    public CardAdapter(Context context, ArrayList<Training> trainings) {
        this.context = context;
        this.trainings = trainings;
    }

    @Override
    public void onItemClick(TrainingHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    @NonNull
    @Override
    public TrainingHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_training, parent, false);
        return new TrainingHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingHolder holder, int position) {
        Training training = trainings.get(position);
        holder.setDetails(training);
    }

    public void setOnItemClickListener(OnItemClickListener listeners) {
        this.listener = listeners;
    }


    @Override
    public int getItemCount() { return trainings.size(); }

    static class TrainingHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtTime, txtCalorie, txtDifficulty;

        public TrainingHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtCalorie = itemView.findViewById(R.id.txtCalorie);
            txtDifficulty = itemView.findViewById(R.id.txtDifficulty);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(TrainingHolder.this, view, position);
                    }
                }
            });
        }

//        TrainingHolder(View itemView) {

        void setDetails(Training training) {
            txtName.setText(training.getTraingingName());
            txtTime.setText(String.format(Locale.US, "Time Required : %d minute", training.getTimeRequired()));
            txtCalorie.setText(String.format(Locale.US, "Calorie Consumption : %d kcal", training.getCalorieConsumption()));
            txtDifficulty.setText(String.format(Locale.US, "Difficulty : %s", training.getDifficulty()));
        }

    }
    public Training getItem(int position){ return trainings.get(position); }


}
