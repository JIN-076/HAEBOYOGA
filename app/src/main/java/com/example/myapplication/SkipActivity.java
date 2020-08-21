package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkipActivity extends AppCompatActivity {

    Button retry;
    Button nextS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);

        retry = (Button) findViewById(R.id.b_retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),CamActivity.class);//home 버튼으로 가는 버튼
                startActivity(intent2);
            }
        });
        nextS = (Button) findViewById(R.id.b_nextS);
        nextS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), CamActivity2.class);//my page로 돌가는 버튼
                startActivity(intent3);
            }
        });
    }
}