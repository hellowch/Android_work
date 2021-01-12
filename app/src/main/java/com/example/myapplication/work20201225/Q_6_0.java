package com.example.myapplication.work20201225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Q_6_0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_6_0);
    }

    public void click01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_6_1");
        startActivity(intent);
    }

    public void click02(View v){
        Intent intent = new Intent();
        intent.setAction("activity_6_2");
        startActivity(intent);
    }

    public void click03(View v){
        Intent intent = new Intent();
        intent.setAction("activity_6_3");
        startActivity(intent);
    }
}