package com.example.database_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDatabase database=new MyDatabase(MainActivity.this);
        database.addContact("Abc","95102454545");
        Cursor cursor=database.showData();

        while (cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String number=cursor.getString(2);
            Log.d("YYY", "ID=:"+id+"\tName="+name+"\tNumber="+number);
        }
    }
}