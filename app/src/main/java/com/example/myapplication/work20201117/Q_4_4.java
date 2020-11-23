package com.example.myapplication.work20201117;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class Q_4_4 extends AppCompatActivity {

    private Q_4_4_aidl q_4_4_aidl;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            q_4_4_aidl = Q_4_4_aidl.Stub.asInterface(service);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            q_4_4_aidl = null;
        }
    };

    private boolean isBound = false;
    TextView labelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_4_4);

        labelView = (TextView)findViewById(R.id.label);
        Button bindButton = (Button)findViewById(R.id.bind);
        Button unbindButton = (Button)findViewById(R.id.unbind);
        Button computButton = (Button)findViewById(R.id.compute_add);

        bindButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isBound){
                    final Intent serviceIntent = new Intent(Q_4_4.this,Q_4_4_Service.class);
                    bindService(serviceIntent,mConnection, Context.BIND_AUTO_CREATE);
                    isBound = true;
                }
            }
        });

        unbindButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBound){
                    isBound = false;
                    unbindService(mConnection);
                    q_4_4_aidl = null;
                }
            }
        });

        computButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (q_4_4_aidl == null){
                    labelView.setText("未绑定远程服务");
                    return;
                }
                long a = Math.round(Math.random()*100);
                long b = Math.round(Math.random()*100);
                long result = 0;
                try {
                    result = q_4_4_aidl.Add(a, b);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                String msg = String.valueOf(a)+" + "+String.valueOf(b)+
                        " = "+String.valueOf(result);
                labelView.setText(msg);
            }
        });
    }
}