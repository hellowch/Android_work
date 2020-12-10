package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class Q_5_1 extends AppCompatActivity {

    private EditText username;
    private EditText password;
    SharedPreferences login_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_1);

        username = findViewById(R.id.username2);
        password = findViewById(R.id.password2);
    }

    //登录按钮
    public void login(View v){
        String name = username.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        //判断是否为空
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
            Toast.makeText(Q_5_1.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            //登录逻辑
            /**
             * name 自动创建的一个xml文件名
             * mode 模式
             */
            login_sp = getSharedPreferences("config",0);

            //获取sp的编辑器
            SharedPreferences.Editor edit = login_sp.edit();
            edit.putString("name",name);
            edit.putString("pwd",pwd);

            //往SharedPreferences提交信息
            edit.commit();

            Intent intent = new Intent();
            intent.setAction("activity_5_1_1");
            startActivity(intent);
        }
    }

    public void click(View v){
        Intent intent = new Intent();
        intent.setAction("activity_5_2");
        startActivity(intent);
    }

}