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

public class training_list_fitness extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<Training> trainingArrayList;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_list_fitness);
        initView();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Trainging List with fitness");

        // 7. ListView 객체의 특정 아이템 클릭시 처리를 추가합니다.

        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(CardAdapter.TrainingHolder holder, View view, int position) {
                Training item = adapter.getItem(position);
                String selected_item = item.getTraingingName();

                if(selected_item.equals("스쿼트")){
                    Intent intent0 = new Intent(getApplicationContext(),CamActivity_fitness_1.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent0);
                }
                else if(selected_item.equals("런지")){
                    Intent intent1 = new Intent(getApplicationContext(),CamActivity_fitness_2.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent1);
                }
                else if(selected_item.equals("덤벨")){
                    Intent intent2 = new Intent(getApplicationContext(),CamActivity_fitness_3.class);//지인쓰 카메라쪽으로 갈 예정
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
        Training training = new Training("스쿼트", 10, 40, "약");
        trainingArrayList.add(training);
        training = new Training("덤벨", 5, 60, "강");
        trainingArrayList.add(training);
        training = new Training("런지", 15, 50, "중");
        trainingArrayList.add(training);
        adapter.notifyDataSetChanged();
    }

}


