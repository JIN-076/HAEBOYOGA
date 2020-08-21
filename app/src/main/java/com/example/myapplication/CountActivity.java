package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.os.Bundle;

public class CountActivity extends AppCompatActivity {

    private TextView mCountDown;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

    }

    private Handler autoCountHandler = new Handler();
    private Runnable autoCountRunnable = new Runnable() {
        @Override
        public void run() {
            count--;
            mCountDown.setText(String.valueOf(count));
            if (count > 0)
            {
                autoCountHandler.postDelayed(autoCountRunnable, 1000);
            }
            else
            {
                if (autoCountHandler != null)
                {
                    autoCountHandler.removeCallbacks(autoCountRunnable);
                }
            }
        }
    };

    @Override
    public void onPause()
    {
        super.onPause();
        if (autoCountHandler != null)
        {
            autoCountHandler.removeCallbacks(autoCountRunnable);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.l, menu);
//        return true;
//    }



}