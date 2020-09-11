package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMypage extends Fragment {

    Button b1;
    Button return_b;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_fragment_mypage, container, false);
        b1 = (Button) view.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), mypage_af.class);//저장하기 버튼
                startActivity(intent1);
            }
        });

        return_b = (Button) view.findViewById(R.id.b_return);
        return_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getContext(),MainActivity.class);//home 버튼을 돌아가는 버튼
                startActivity(intent0);
            }
        }) ;
    return view;
    }
}