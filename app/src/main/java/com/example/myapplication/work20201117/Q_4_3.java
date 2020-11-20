package com.example.myapplication.work20201117;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Q_4_3 extends AppCompatActivity {

    private EditText oneNumber, twoNumber;
    private TextView tView;
    private Button btn_true;
    private Button startBtn;
    private Button stopBtn;
    private Q_4_3_Service q_4_3_Service;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_4_3);

        oneNumber = (EditText) findViewById(R.id.one_number);
        twoNumber = (EditText) findViewById(R.id.two_number);
        tView = (TextView) findViewById(R.id.tview);
        btn_true = (Button) findViewById(R.id.btn_true);
        startBtn = (Button) findViewById(R.id.start);
        stopBtn = (Button) findViewById(R.id.stop);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBound){
                    final Intent serviceIntent = new Intent(Q_4_3.this,Q_4_3_Service.class);
                    bindService(serviceIntent,cnn, Context.BIND_AUTO_CREATE);
                    isBound = true;
                }
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound){
                    isBound = false;
                    unbindService(cnn);
                    q_4_3_Service=null;
                }
            }
        });

        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (q_4_3_Service == null){
                    tView.setText("未绑定服务");
                    return;
                }
                tView.setText(q_4_3_Service.IntCompare(oneNumber.getText().toString(),twoNumber.getText().toString()));
            }
        });

    }

    private ServiceConnection cnn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            q_4_3_Service = ((Q_4_3_Service.LocalBinder)service).getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            q_4_3_Service = null;
        }
    };



    public void click03(View v){
        Intent intent = new Intent();
        intent.setAction("activity_4_4");
        startActivity(intent);
    }
}