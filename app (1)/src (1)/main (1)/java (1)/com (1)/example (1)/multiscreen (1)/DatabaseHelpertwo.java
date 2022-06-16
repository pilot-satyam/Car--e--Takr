package com.example.multiscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelpertwo extends SQLiteOpenHelper {
    public DatabaseHelpertwo(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text, name text, phonenumber text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }
    // inserting in database
    public boolean insert(String email,String password,String name, String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);
        contentValues.put("name",name);
        contentValues.put("Phone num",phonenumber);
       // contentValues.put("phonenumber",phonenumber);
        long ins= db.insert("user",null,contentValues);
        if (ins ==-1) return false;
        else return  true;
    }
    public Boolean checkmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email = ?", new  String[]{email});
        if(cursor.getCount()>0 )return false;
        else  return true;



    }



}
