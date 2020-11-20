package com.example.myapplication.work20201117;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class Q_4_1 extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_4_1);

        startBtn = (Button) findViewById(R.id.start);
        stopBtn = (Button) findViewById(R.id.stop);
        startBtn.setOnClickListener(this);
        assert stopBtn != null;
        stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent it = new Intent(this,Q_4_1_Service.class);
        switch (v.getId()){
            case R.id.start:
                startService(it);
                break;
            case R.id.stop:
                stopService(it);
                break;
        }
    }

    public void Click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_4_2");
        startActivity(intent);
    }
}