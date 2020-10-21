package com.example.myapplication.work20201017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myapplication.R;

public class Q_2_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_2_5);


        //获取布局文件中添加的帧布局管理器
        FrameLayout ll=(FrameLayout)findViewById(R.id.frameLayout1);
        //将自定义的MyView视图添加到帧布局
        ll.addView(new MyView(this));

    }



    public class MyView extends View {
        public MyView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }
        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint=new Paint();
            paint.setAntiAlias(true);//使用抗锯齿功能
            paint.setColor(Color.GREEN);
            //绘制机器人的头
            RectF rectf_head=new RectF(10,10,100,100);
            rectf_head.offset(100, 20);//设置在X轴上偏移100像素，Y轴上偏移20像素
            canvas.drawArc(rectf_head, -10, -160, false, paint);//绘制弧
			/*.drawArc参数1：圆的范围大小；参数2：起始角度 ；
			参数3：圆心角角度，360为圆，180为半圆；
			参数4：中心 ；参数5：画笔Paint；*/
            //绘制眼睛
            paint.setColor(Color.WHITE);
            canvas.drawCircle(135, 53, 4, paint);//绘制圆
            canvas.drawCircle(175, 53, 4, paint);//绘制圆
            paint.setColor(Color.GREEN);
            //绘制天线
            paint.setStrokeWidth(2);//设置触笔的宽度
            canvas.drawLine(120, 15, 135, 35, paint);//绘制线
            canvas.drawLine(190, 15, 175, 35, paint);//绘制线
            //绘制身体
            canvas.drawRect(110,75,200,150, paint);//绘制矩形
            RectF rectf_body=new RectF(110,140,200,160);
            canvas.drawRoundRect(rectf_body, 10, 10, paint);//绘制圆角矩形
			/*参数说明
			rect：RectF对象。
			rx：x方向上的圆角半径。
			ry：y方向上的圆角半径。
			paint：绘制时所使用的画笔。*/

            //绘制胳膊
            RectF rectf_arm=new RectF(85,75,105,140);
            canvas.drawRoundRect(rectf_arm, 10, 10, paint);
            rectf_arm.offset(120, 0);//设置在X轴上偏移120像素
            canvas.drawRoundRect(rectf_arm, 10, 10, paint);
            //绘制腿
            RectF rectf_leg=new RectF(125,150,145,200);
            canvas.drawRoundRect(rectf_leg, 10, 10, paint);
            rectf_leg.offset(40, 0);//设置在X轴上偏移40像素
            canvas.drawRoundRect(rectf_leg, 10, 10, paint);
            super.onDraw(canvas);
        }
    }

}