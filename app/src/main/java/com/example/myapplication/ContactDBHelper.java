package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1 ;
    public static final String DBFILE_CONTACT = "homet.db" ;

    public ContactDBHelper (FragmentHome context) {
        super (context, DBFILE_CONTACT, null, DB_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

    }
    public void onStart(SQLiteDatabase db) {
        //db.execSQL(ContactDBCtrct.SQL_DROP_TBL) ;
        db.execSQL(ContactDBCtrct.SQL_CREATE_TBL);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db.execSQL(ContactDBCtrct.SQL_DROP_TBL) ;
        onCreate(db);
    }
    public void onDowngrade (SQLiteDatabase db) {
        db.execSQL(ContactDBCtrct.SQL_DROP_TBL) ;
    }
}
