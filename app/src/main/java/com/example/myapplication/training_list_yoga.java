package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class training_list_yoga extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<Training> trainingArrayList;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_list_yoga);
        initView();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Trainging List with yoga");

        // 7. ListView 객체의 특정 아이템 클릭시 처리를 추가합니다.

        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(CardAdapter.TrainingHolder holder, View view, int position) {
                Training item = adapter.getItem(position);
                String selected_item = item.getTraingingName();

                if(selected_item.equals("힐링 반야사")){
                    Intent intent0 = new Intent(getApplicationContext(),CamActivity_yoga_1.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent0);
                }
                else if(selected_item.equals("하타 요가")){
                    Intent intent1 = new Intent(getApplicationContext(),CamActivity_yoga_2.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent1);
                }
                else if(selected_item.equals("마이링 플로우")){
                    Intent intent2 = new Intent(getApplicationContext(),CamActivity_yoga_3.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent2);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trainingArrayList = new ArrayList<>();
        adapter = new CardAdapter(this, trainingArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        createListData();
    }

    private void createListData() {
        Training training = new Training("힐링 반야사", 30, 120, "중");
        trainingArrayList.add(training);
        training = new Training("하타 요가", 30, 150, "강");
        trainingArrayList.add(training);
        training = new Training("마이링 플로우", 25, 100, "약");
        trainingArrayList.add(training);
        adapter.notifyDataSetChanged();
    }

}


