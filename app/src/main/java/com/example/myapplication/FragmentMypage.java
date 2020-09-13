package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentMypage extends Fragment {

    Button info_b; // 정확히 몰것당,,,
    Button return_b; // 이전 버튼
    Button buttonSave; // STORE 버튼
    Button buttonClear; // RESET 버튼 ??

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.main_fragment_mypage, container, false);

        final ContactDBHelper dbHelper = new ContactDBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        dbHelper.onStart(db);
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;

        buttonSave = (Button) view.findViewById(R.id.button1);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dbinsert(dbHelper);
                SQLiteDatabase db = dbHelper.getWritableDatabase() ;
                //name edit text에 적은 내용을 가져온다.
                EditText editTextName = (EditText) view.findViewById (R.id.eTName);
                String name = editTextName.getText().toString();

                //old edit text에 적은 내용을 가져온다.
                EditText editTextold = (EditText) view.findViewById (R.id.eTOld);
                int old = Integer.parseInt(editTextold.getText().toString());

                //tall edit text에 적은 내용을 가져온다.
                EditText editTexttall = (EditText) view.findViewById (R.id.eTTall);
                int tall = Integer.parseInt(editTexttall.getText().toString());

                //weight edit text에 적은 내용을 가져온다.
                EditText editTextweight = (EditText) view.findViewById(R.id.eTWeight);
                int weight = Integer.parseInt(editTextweight.getText().toString());


                String sqlInsert = ContactDBCtrct.SQL_INSERT +
                        " (" +
                        "'" + name + "', " +
                        Integer.toString(old) + ", " +
                        Integer.toString(tall) + ", " +
                        Integer.toString(weight)  +
                        ")" ;
                db.execSQL(sqlInsert);
                Intent intent1 = new Intent(getContext(), mypage_af.class);//저장하기 버튼
                startActivity(intent1);
            }
        });

        return_b = (Button) view.findViewById(R.id.b_return);
        return_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getContext(),MainActivity2.class);//home 버튼을 돌아가는 버튼
                startActivity(intent0);
            }
        }) ;

        buttonClear = (Button) view.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                dbHelper.onDowngrade(db);
            }
        });

        info_b = (Button) view.findViewById(R.id.b_info);
        info_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor == null || cursor.getCount() ==0) {
                    Intent intent3 = new Intent(getContext(),FragmentMypage.class);//my page로 돌가는 버튼
                    startActivity(intent3);
                }
                else {
                    Intent intent2 = new Intent(getContext(),mypage_af.class);
                    startActivity(intent2);
                }
            }
        });
    return view;
    }
}