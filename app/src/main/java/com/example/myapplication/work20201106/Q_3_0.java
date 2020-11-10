package com.example.myapplication.work20201106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Q_3_0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_3_0);
    }

    public void click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_3_1");
        startActivity(intent);
    }

    public void click_02(View v){
        Intent intent = new Intent();
        intent.setAction("activity_3_2");
        startActivity(intent);
    }
}