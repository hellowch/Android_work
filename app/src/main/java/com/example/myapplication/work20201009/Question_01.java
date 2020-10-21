package com.example.myapplication.work20201009;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Question_01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayHellow(View v){
        //获取代表布局中EditText和TextView对象
        EditText name = (EditText)findViewById(R.id.name);
        EditText class_id = (EditText)findViewById(R.id.class_id);
        EditText student_id = (EditText)findViewById(R.id.student_id);
        TextView txv = (TextView)findViewById(R.id.txv);

        final CheckBox name_btn = (CheckBox) findViewById(R.id.name_btn); //获取复选按钮
        final CheckBox class_id_btn = (CheckBox) findViewById(R.id.class_id_btn);
        final CheckBox student_id_btn = (CheckBox) findViewById(R.id.student_id_btn);

        String str="";
        if (name_btn.isChecked()){
            str += name.getText().toString() + "\n";
        }
        if (class_id_btn.isChecked()){
            str += class_id.getText().toString() + "\n";
        }
        if (student_id_btn.isChecked()){
            str += student_id.getText().toString();
        }

        //将EditText文字串连接自定义信息再设置给TextView
        txv.setText(str);
    }

    public void click01(View v){
        Intent intent = new Intent();
        intent.setAction("activity2");
        startActivity(intent);
    }
}