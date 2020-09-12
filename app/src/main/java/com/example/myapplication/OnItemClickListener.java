package com.example.myapplication;

import android.view.View;

public interface OnItemClickListener {
    public void onItemClick(CardAdapter.TrainingHolder holder, View view, int position);
}
