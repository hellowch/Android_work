package com.example.myapplication.work20201009;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myapplication.R;

public class Q_1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_1_2);

        final RadioGroup sex = (RadioGroup) findViewById(R.id.RadioGroup1);
        //为单选按钮组添加事件监听
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton RB=(RadioButton) findViewById(i);//获取被选择的单选按钮
                TextView txv = (TextView)findViewById(R.id.textView6);
                //将EditText文字串连接自定义信息再设置给TextView
                txv.setText("江苏省GDP排名第一的城市是："+RB.getText());
            }
        });
    }

    public void click02(View v){
        Intent intent = new Intent();
        intent.setAction("activity_1_3");
        startActivity(intent);
    }
}