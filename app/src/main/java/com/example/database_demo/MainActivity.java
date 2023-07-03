package com.example.database_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    List<Integer> idList=new ArrayList<>();
    List<String> nameList=new ArrayList<>();
    List<String> numberList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDatabase database=new MyDatabase(MainActivity.this);
        //database.addContact("Ghi","8898866666");
        Cursor cursor=database.showData();
        //database.deleteData(4);
        database.updateData(3,"JKL","8898866666");

        while (cursor.moveToNext())
        {
            idList.add(cursor.getInt(0));
            nameList.add(cursor.getString(1));
            numberList.add(cursor.getString(2));

        }
        Log.d("YYY", "ID=:"+idList+"\tName="+nameList+"\tNumber="+numberList);
    }
}