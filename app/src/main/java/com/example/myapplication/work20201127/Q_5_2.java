package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.FileOutputStream;
import java.io.IOException;

public class Q_5_2 extends AppCompatActivity {

    private EditText username;
    private EditText password;
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_2);

        username = findViewById(R.id.username3);
        password = findViewById(R.id.password3);

    }

    //登录功能
    public void login(View v){
        String name = "用户名：" + username.getText().toString().trim();
        String pwd = "  密码：" + password.getText().toString().trim();
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
            Toast.makeText(Q_5_2.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            try {
                //打开输出流，并创建文件 存储的数据在：/data/data/<应用包名>/files ，文件夹下面
                outputStream = openFileOutput("filename",MODE_PRIVATE);
                //将数据保存到文件中
                outputStream.write(name.getBytes());
                outputStream.write(pwd.getBytes());
                //关闭输出流
                outputStream.close();

            }catch (IOException e){
                e.printStackTrace();
            }

            Intent intent = new Intent();
            intent.setAction("activity_5_2_1");
            startActivity(intent);
        }
    }

    public void click(View v){
        Intent intent = new Intent();
        intent.setAction("activity_5_3");
        startActivity(intent);
    }
}