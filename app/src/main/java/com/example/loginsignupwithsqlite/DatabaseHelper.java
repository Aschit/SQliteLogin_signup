package com.example.loginsignupwithsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //assign the variable
    // final is used for no assign

    public static final String Database_Name = "login.db";

    public DatabaseHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(email TEXT Primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop  table if  exists users");

    }

    public boolean insertUsers(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        Long result = sqLiteDatabase.insert("users", null, contentValues);
        if (result == -1) {
            return false;

        } else {
            return true;


        }
    }

    public boolean checkEmailPassword(String email, String password) {

    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where email= ? and password= ?"
            , new String[]{email, password});

    if(cursor.getCount()>0)

    {
        return true;

    }else

    {
        return false;
    }

}

public  boolean checkEmail(String email){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from users where email=?",new String[]{email});

        if (cursor.getCount()>0){
            return  true;
        }else{
            return false;

        }
}

}
