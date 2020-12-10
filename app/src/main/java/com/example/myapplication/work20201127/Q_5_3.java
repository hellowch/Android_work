package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Q_5_3 extends AppCompatActivity {

    private TextView tv;
    private Button btn_raw;
    private Button btn_xml;
    private Context mContext = Q_5_3.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_3);

        tv = findViewById(R.id.tv01);
        btn_raw = findViewById(R.id.btn_raw);
        btn_xml = findViewById(R.id.btn_xml);
    }

    public void click_raw(View v) {
        //把文件转换为输入流
        InputStream is_raw = mContext.getResources().openRawResource(R.raw.text_5_3);
        //创建StringBuffer实例
        StringBuffer buffer = new StringBuffer();
        //根据is_raw 创建缓冲字符输入流
        BufferedReader br_raw = new BufferedReader(new InputStreamReader(is_raw));

        String text_raw = null;
        try {
            //把这一行的值赋值给变量text_raw，并判断是否有值
            while ((text_raw = br_raw.readLine()) != null) {
                //把值添加进StringBuffer
                buffer.append(text_raw);
                //显示内容
                tv.setText(buffer);
            }
            //调用close函数关掉输入流
            is_raw.close();
            //调用close函数关掉缓冲字符输入流
            br_raw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click_xml(View v) throws XmlPullParserException, IOException {
        //通过id访问资源
        XmlResourceParser xmlParser  = getResources().getXml(R.xml.text5_3);

        //用于记录数据
        StringBuffer xmlBuffer = new StringBuffer();

        try {
            //获取解析光标
            int event = xmlParser.getEventType();
            //如果文档没结束，则继续向下遍历
            while (event != XmlPullParser.END_DOCUMENT){
                switch (event){
                    case XmlPullParser.START_DOCUMENT:
                        Log.i("Q_5_3","xml解析开始");
                        break;
                    case XmlPullParser.START_TAG:
                        //xmlParser.getName()获取当前标签名字
                        Log.i("Q_5_3","当前标签是: " + xmlParser.getName());
                        if (xmlParser.getName().equals("person")){
                            //获取该标签中的属性值
                            //把值添加进StringBuffer
                            xmlBuffer.append(xmlParser.getAttributeName(0) + ":" + xmlParser.getAttributeValue(null,"height") + "  ");
                            xmlBuffer.append(xmlParser.getAttributeName(1) + ":" + xmlParser.getAttributeValue(null,"age") + "  ");
                            xmlBuffer.append(xmlParser.getAttributeName(2) + ":" + xmlParser.getAttributeValue(null,"name") + " \n");
                        }
                        break;
                    case XmlPullParser.TEXT:
                        //获取正文，但是俺们没正文
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    default:
                        break;
                }
                //光标向下移一步
                event = xmlParser.next();
            }

            tv.setText(xmlBuffer);

        }catch (XmlPullParserException e){
            e.printStackTrace();
        }

    }

    public void click(View v){
        Intent intent = new Intent();
        intent.setAction("activity_5_5");
        startActivity(intent);
    }
}