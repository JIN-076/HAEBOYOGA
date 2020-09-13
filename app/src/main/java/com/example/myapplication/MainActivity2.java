package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity2 extends AppCompatActivity {

    public int check = 0;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentMypage fragmentMypage = new FragmentMypage();
    private FragmentMypage_after fragmentMypageAfter = new FragmentMypage_after();

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_View);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListner());
    }


    class ItemSelectedListner implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

            ContactDBHelper helper = new ContactDBHelper(getApplicationContext());
            SQLiteDatabase db = helper.getReadableDatabase();
            if (check == 0)//어플을 처음 깔았을때만 table이 만들어진다.
            {
                helper.onStart(db);
            }
            final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null);

                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                        break;

                    case R.id.mypage:
                        if (cursor == null || cursor.getCount() ==0) {
                            transaction.replace(R.id.frameLayout, fragmentMypage).commitAllowingStateLoss();
                            break;
                        }
                        else {
                            transaction.replace(R.id.frameLayout, fragmentMypageAfter).commitAllowingStateLoss();
                            break;
                        }

                }
                return true;
            }
    }

}