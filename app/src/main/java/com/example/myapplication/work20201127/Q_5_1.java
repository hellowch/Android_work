package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Q_5_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_1);
    }


    public void click(View v){
        Intent intent = new Intent();
        intent.setAction("activity_5_2");
        startActivity(intent);
    }

}