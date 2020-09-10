package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkipActivity_fitness_3 extends AppCompatActivity {

    Button retry;
    Button nextS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_fitness_3);

        retry = (Button) findViewById(R.id.b_retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),CamActivity_fitness_3.class);// 현재 동작 다시하기 버튼
                startActivity(intent2);
            }
        });
        nextS = (Button) findViewById(R.id.b_nextS);
        nextS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), FinalActivity.class);// 다음 동작 넘어가기 버튼
                startActivity(intent3);
            }
        });
    }
}