package com.example.myapplication.work20201017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.R;

public class Q_2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_2_1);
    }


    public boolean onTouchEvent(MotionEvent event){
        // 在这里判断一下如果是按下操作就获取坐标然后执行方法
        String str="";
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            str = String.valueOf("x: "+event.getX()+"  y: "+event.getY());
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }

    public void click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_2_2");
        startActivity(intent);
    }
}