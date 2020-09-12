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
import android.widget.ImageView;

public class FragmentHome extends Fragment {

    public static int n = 0;
    public int flag1 = 0;

    ImageView imageView = null;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_home, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(new MyListener());
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flag1 == 0) {
//                    Intent intent0 = new Intent(getContext(), training_list_yoga.class);//지인쓰 카메라쪽으로 갈 예정
//                    startActivity(intent0);
//                } else {
//                    if (MainActivity.n == 0) {
//                        Intent intent1 = new Intent(getContext(), training_list_yoga.class);//지인쓰 카메라쪽으로 갈 예정
//                        startActivity(intent1);
//                    } else if (MainActivity.n == 1) {
//                        Intent intent2 = new Intent(getContext(), training_list_pilates.class);//지인쓰 카메라쪽으로 갈 예정
//                        startActivity(intent2);
//                    } else if (MainActivity.n == 2) {
//                        Intent intent3 = new Intent(getContext(), training_list_fitness.class);//지인쓰 카메라쪽으로 갈 예정
//                        startActivity(intent3);
//                    }
//                }
//            }
//        });
        ImageView right = (ImageView) view.findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n == 0) {
                    imageView.setImageResource(R.drawable.real_pilates);
                    n = 1;
                    flag1 = 1;
                } else if (n == 1) {
                    imageView.setImageResource(R.drawable.real_fitness);
                    n = 2;
                } else if (n == 2) {
                    imageView.setImageResource(R.drawable.real_real_yoga);
                    n = 0;
                }
                System.out.println("n is " + n);
            }
        });
        ImageView left = (ImageView) view.findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n == 0) {
                    imageView.setImageResource(R.drawable.real_fitness);
                    n = 2;
                    flag1 = 1;
                } else if (n == 1) {
                    imageView.setImageResource(R.drawable.real_real_yoga);
                    n = 0;
                } else if (n == 2) {
                    imageView.setImageResource(R.drawable.real_pilates);
                    n = 1;
                }
                System.out.println("n is " + n);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        //밑에 있는 거는 모든 페이지에서 필요한 버튼들 2,3,0
    return view;
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(flag1==0){
                Intent intent0 = new Intent(getContext(), training_list_yoga.class);//지인쓰 카메라쪽으로 갈 예정
                startActivity(intent0);
            }
            else {
                if (FragmentHome.n == 0) {
                    Intent intent1 = new Intent(getContext(), training_list_yoga.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent1);
                } else if (FragmentHome.n == 1) {
                    Intent intent2 = new Intent(getContext(), training_list_pilates.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent2);
                } else if (FragmentHome.n == 2) {
                    Intent intent3 = new Intent(getContext(), training_list_fitness.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent3);
                }
            }
        } // end onClick


    } // end MyListener()
}
