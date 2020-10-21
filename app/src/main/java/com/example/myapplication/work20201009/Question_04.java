package com.example.myapplication.work20201009;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Question_04 extends AppCompatActivity {
    private Thread thread;
    private Handler handler;  //异步消息处理器
    private TextView tvTime;
    private SimpleDateFormat sdf;
    private boolean runing;
    private TextView Tv1;
    private Button Btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvTime = findViewById(R.id.tv_1);
        sdf = new SimpleDateFormat("hh:mm:ss");
        tvTime.setText(sdf.format(new Date()));

        //创建消息处理器 接受子线程发送的消息  根据它做出处理，跟新主界面的值
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    tvTime.setText(sdf.format(new Date()));
                }
            }
        };
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //让线程  发送消息
                    handler.sendEmptyMessage(1);
                    //让线程  睡眠500毫秒
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //启动线程
        thread.start();
    }


    public void login(View v){

        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        String un = username.getText().toString();
        String pw = password.getText().toString();

        Toast.makeText(getApplicationContext(),"用户登录成功",Toast.LENGTH_LONG).show();
    }


    public void reset(View v){
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        username.setText(null);
        password.setText(null);

        Toast.makeText(getApplicationContext(),"重置成功",Toast.LENGTH_LONG).show();
    }


 }