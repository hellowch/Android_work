package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void click_menu_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_1_1");
        startActivity(intent);
    }

    public void click_menu_02(View v){
        Intent intent = new Intent();
        intent.setAction("activity_2_1");
        startActivity(intent);
    }

    public void click_menu_03(View v){
        Intent intent = new Intent();
        intent.setAction("activity_3_0");
        startActivity(intent);
    }
}