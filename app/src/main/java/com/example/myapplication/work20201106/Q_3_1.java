package com.example.myapplication.work20201106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Q_3_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_3_1);
        final Button Login = findViewById(R.id.login);
    }





    public void click_01(View v){
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        String username1 = username.getText().toString();
        String password1 = password.getText().toString().trim();

        System.out.println(username1 + "+" + password1);

        if (username1.equals("wch") && password1.equals("123456")){
            Intent intent = new Intent();
            intent.setAction("activity_3_1_1");
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"账号或密码错误",Toast.LENGTH_LONG).show();
        }
    }
}