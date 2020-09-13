package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentMypage_after extends Fragment {

    Button b1;
    TextView textViewName;
    TextView textViewOld ;
    TextView textViewTall;
    TextView textViewWeight ;

//    private FragmentActivity mContext;
//
//    @Override
//    public void onAttach(Activity activity) {
//        mContext=(FragmentActivity) activity;
//        super.onAttach(activity);
//    }

    public static FragmentMypage_after newInstance() {
        return new FragmentMypage_after();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment_mypage_after, container, false);

        final ContactDBHelper dbHelper = new ContactDBHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;

        textViewName = (TextView) view.findViewById(R.id.textName);
        textViewOld = (TextView) view.findViewById(R.id.textOld);
        textViewTall = (TextView) view.findViewById(R.id.textTall);
        textViewWeight = (TextView) view.findViewById(R.id.textWeight);
        b1 = (Button) view.findViewById(R.id.buttonreturn);//return으로 다시 회원 정보를 기입

        setText(cursor);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase() ;
                dbHelper.onDowngrade(db);//회원정보를 다 지우고 다시 기입할 수 있게 함
//                Intent intent1 = new Intent(getContext(), FragmentMypage.class);
//                startActivity(intent1);
                ((MainActivity2)getActivity()).replaceFragment(FragmentMypage.newInstance());
            }
        });
        return view;
    }

    void setText (Cursor cursor){
        cursor.moveToFirst();
        textViewName.setText(cursor.getString(0));
        textViewOld.setText(Integer.toString(cursor.getInt(1)));
        textViewTall.setText(Integer.toString(cursor.getInt(2)));
        textViewWeight.setText(Integer.toString(cursor.getInt(3)));
    }



}
