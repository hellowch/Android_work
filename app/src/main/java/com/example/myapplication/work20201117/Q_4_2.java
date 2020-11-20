package com.example.myapplication.work20201117;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.security.Provider;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q_4_2 extends AppCompatActivity {

    protected static final String TAG = "demo";
    private Button btnBind;
    private Button btnUnBind;
    private TextView newTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_4_2);

        btnBind = (Button) findViewById(R.id.Bind);
        btnUnBind = (Button) findViewById(R.id.UnBind);
        newTime = (TextView) findViewById(R.id.new_Time);

        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        //创建消息处理器 接受子线程发送的消息  根据它做出处理，跟新主界面的值
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    newTime.setText(time.format(new Date()));
                }
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //让线程  发送消息
                    handler.sendEmptyMessage(1);
//                    Log.d(TAG, "time: "+handler.sendEmptyMessage(1));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //启动线程
        thread.start();
    }

    public void bind(View v){
        //显示TextView
        newTime.setVisibility(View.VISIBLE);
    }

    public void noBing(View v){
        //不显示TextView
        newTime.setVisibility(View.INVISIBLE);
    }

    public void click02(View v){
        Intent intent = new Intent();
        intent.setAction("activity_4_3");
        startActivity(intent);
    }

}