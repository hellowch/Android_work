package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class Q_5_1_1 extends AppCompatActivity {

    private TextView username;
    private TextView password;
    SharedPreferences login_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_1_1);

        //初始化实例
        login_sp = getSharedPreferences("config",0);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //从config.xml中获取数据
        String name = login_sp.getString("name","");
        String pwd = login_sp.getString("pwd","");

        //显示数据
        username.setText("用户名: "+name);
        password.setText("密码: "+pwd);
    }
}