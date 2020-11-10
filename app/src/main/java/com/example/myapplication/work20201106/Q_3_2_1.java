package com.example.myapplication.work20201106;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;

public class Q_3_2_1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_3_2_1);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}