package com.example.myapplication.work20201106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Objects;

public class Q_3_1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_3_1_1);
    }

    public void click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_3_1");
        startActivity(intent);
    }


}