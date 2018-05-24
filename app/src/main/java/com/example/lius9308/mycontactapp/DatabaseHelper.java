package com.example.lius9308.mycontactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contact2018.db";
    public static final String TABLE_NAME = "Contact2018_table";
    public static final String ID = "ID";
    public static final String COLUMN_NAME_CONTACT = "contact";
    public static final String PHONE_NUMBER = "858123456";
    public static final String ADDRESS_NAME = "address";



    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_CONTACT + PHONE_NUMBER + ADDRESS_NAME + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
         Log.d("MyContactApp", "DatabaseHelper: constructed DatabaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MyContactApp", "DatabaseHelper: creating database");
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MyContactApp", "DatabaseHelper: upgrading database");
        db.execSQL(SQL_DELETE_ENTRIES);

    }

    public boolean insertData(String name, String phone, String address)
    {
        Log.d("MyContactApp", "DatabaseHelper: attempting to insert data");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_CONTACT, name);
        contentValues.put(PHONE_NUMBER, phone);
        contentValues.put(ADDRESS_NAME, address);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
        {
            Log.d("MyContactApp", "DatabaseHelper: Contact insert failed");
            return false;
        }
        else
        {
            Log.d("MyContactApp", "DatabaseHelper: Contact insert passed");
            return true;
        }
    }
}
