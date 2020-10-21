package com.example.myapplication.work20201017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.myapplication.R;

public class Q_2_4 extends AppCompatActivity {

    private TabHost tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_2_4);

        //获取该Activity里面的TabHost组件
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        //初始化TabHost容器
        tabs.setup();

        //资源对象
        Resources res = getResources();

        TabHost.TabSpec spec;
        //创建第一个Tab页
        spec = tabs.newTabSpec("tab1")
                .setIndicator("tab1")	//设置标题
                .setContent(R.id.tab1);	//设置内容
        //添加第一个标签页
        tabs.addTab(spec);

        //res.getDrawable(R.drawable.wo)添加图片
        spec = tabs.newTabSpec("tab2").setIndicator("tab2").setContent(R.id.tab2);
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tab3").setIndicator("tab3").setContent(R.id.tab3);
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tab4").setIndicator("tab4").setContent(R.id.tab4);
        tabs.addTab(spec);

        //设置默认选项卡,第几个，从0开始
        tabs.setCurrentTab(0);

//        //标签切换事件处理，setOnTabChangedListener
//        //tabId是newTabSpec参数设置的tab页名，
//        tabs.setOnTabChangedListener(tabId -> {
//            if (tabId.equals("tab1")) {   //第一个标签
//                Toast.makeText(Q_2_4.this, "点击tab1", Toast.LENGTH_SHORT).show();
//            }
//            if (tabId.equals("tab2")) {   //第二个标签
//                Toast.makeText(Q_2_4.this, "点击tab2", Toast.LENGTH_SHORT).show();
//            }
//            if (tabId.equals("tab3")) {   //第三个标签
//                Toast.makeText(Q_2_4.this, "点击tab3", Toast.LENGTH_SHORT).show();
//            }
//            if (tabId.equals("tab4")) {   //第四个标签
//                Toast.makeText(Q_2_4.this, "点击tab4", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void click_01(View v){
        Intent intent = new Intent();
        intent.setAction("activity_2_5");
        startActivity(intent);
    }
}