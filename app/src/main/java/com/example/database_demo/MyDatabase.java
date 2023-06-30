package com.example.database_demo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper
{

    public MyDatabase(@Nullable Context context) {
        super(context, "ContactBook", null, 1);
        Log.d("YYY", "MyDatabase: Database Created");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table Contact (ID integer primary key autoincrement,NAME text,NUMBER text)";
        db.execSQL(query);
        Log.d("YYY", "MyDatabase: Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(String name, String number)
    {
        String query="insert into Contact(NAME,NUMBER) values('"+name+"','"+number+"')";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor showData()
    {
        String query="select * from Contact";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        return cursor;
    }
    //update query="update Contact set NAME='"+name+"', NUMBER='"+number+"' where ID="+id+"
    //delete query="delete from Contact where ID="+id+"
}
