package com.example.myapplication.work20201009;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

public class Q_1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_1_3);

        ListView list_main = (ListView)findViewById(R.id.list_main);



        list_main.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //ListView的列表项的单击事件
            @Override
            //第一个参数：指的是这个ListView；第二个参数：当前单击的那个item
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("parent="+parent.getClass());
                System.out.println("view="+view.getClass());
                //既然当前点击的那个item是一个TextView，那我们可以将其强制转型为TextView类型，然后通过getText()方法取出它的内容,紧接着以吐司的方式显示出来
                TextView tv = (TextView)view;

                TextView textView8 = (TextView)findViewById(R.id.textView8);
                textView8.setText("ListView, "+tv.getText()+" ,position="+position+" ,id="+id);

            }

        });



    }

    public void click03(View v){
        Intent intent = new Intent();
        intent.setAction("activity_1_4");
        startActivity(intent);
    }
}