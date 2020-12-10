package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Q_5_2_1 extends AppCompatActivity {

    private TextView username;
    FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_2_1);

        username = findViewById(R.id.username);

        try {
            //获取输入流,打开文件
            inputStream = openFileInput("filename");
            //将数据放入数组
            byte[] buffer = new byte[inputStream.available()];
            //读取数组内容
            inputStream.read(buffer);
            inputStream.close();

            username.setText(new String(buffer));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}