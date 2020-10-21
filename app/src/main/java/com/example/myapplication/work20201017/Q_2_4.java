package com.example.myapplication.work20201017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Q_2_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_2_4);
    }

    public void click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_2_5");
        startActivity(intent);
    }
}