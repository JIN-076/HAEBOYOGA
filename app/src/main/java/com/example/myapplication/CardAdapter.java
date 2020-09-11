package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Training;

import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.TrainingHolder> {

    private Context context;
    private ArrayList<Training> trainings;

    public CardAdapter(Context context, ArrayList<Training> trainings) {
        this.context = context;
        this.trainings = trainings;
    }

    @NonNull
    @Override
    public TrainingHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_training, parent, false);
        return new TrainingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingHolder holder, int position) {
        Training training = trainings.get(position);
        holder.setDetails(training);
    }

    @Override
    public int getItemCount() { return trainings.size(); }

    class TrainingHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtTime, txtCalorie, txtDifficulty;

        TrainingHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtCalorie = itemView.findViewById(R.id.txtCalorie);
            txtDifficulty = itemView.findViewById(R.id.txtDifficulty);
        }

        void setDetails(Training training) {
            txtName.setText(training.getTraingingName());
            txtTime.setText(String.format(Locale.US, "Time Required : %d minute", training.getTimeRequired()));
            txtCalorie.setText(String.format(Locale.US, "Calorie Consumption : %d kcal", training.getCalorieConsumption()));
            txtDifficulty.setText(String.format(Locale.US, "Difficulty : %s", training.getDifficulty()));
        }

    }


}
