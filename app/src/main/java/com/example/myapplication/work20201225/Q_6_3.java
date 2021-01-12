package com.example.myapplication.work20201225;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import static android.content.ContentValues.TAG;

/**
 * Implementation of App Widget functionality.
 */
public class Q_6_3 extends AppWidgetProvider {

    private static Queue<Integer> widgetIds=new LinkedList<Integer>();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Intent intent=new Intent();
        intent.setAction("widget_6_3");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, -1,intent, 0);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.q_6_3);
        remoteViews.setOnClickPendingIntent(R.id.button, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        for (int i = 0 ;i<appWidgetIds.length; i++ ){
            widgetIds.add(appWidgetIds[i]);
            Log.d(TAG," widgetId:" + appWidgetIds[i]+ ", Size:" + widgetIds.size());
        }

        Log.d(TAG, "appWidgetIds.length:" + appWidgetIds.length);
        Toast.makeText(context, "(2) 调用onUpdate() :"  ,  Toast.LENGTH_SHORT).show();
        context.startService(new Intent(context, Service_6_3.class));//拖到桌面时，开启service服务

    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted");
        for (int i = 0; i< appWidgetIds.length ;i++){
            if (widgetIds.contains(appWidgetIds[i])){
                widgetIds.remove((Object)appWidgetIds[i]);
            }
            Log.d(TAG," widgetIds:" + appWidgetIds[i]+ ", Size:" + widgetIds.size());
        }
        Log.d(TAG, "appWidgetIds.length:" + appWidgetIds.length);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        System.out.println("onEnable");
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
        context.stopService(new Intent(context, Service_6_3.class));
    }

    static void updateAppWidget(Context context,String displayMsg) {
        AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(context);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.q_6_3);
        views.setTextViewText(R.id.textView, displayMsg);
        final int N = widgetIds.size();
        for (int i=0; i<N; i++) {
            int appWidgetId = widgetIds.poll();
            appWidgetManager.updateAppWidget(appWidgetId, views);
            widgetIds.add(appWidgetId);
        }

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();//获取intent中的action
        if (action.equals("widget_6_3")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");// HH:mm:ss
            Date date = new Date(System.currentTimeMillis());
            String time = simpleDateFormat.format(date);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.q_6_3);
            remoteViews.setTextViewText(R.id.textView, time);
//下面三句都是为了刷新用，由于onReceive()方法中没有appWidgetManager，所以需要新生成
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName componentName = new ComponentName(context,Q_6_3.class);
            appWidgetManager.updateAppWidget(componentName, remoteViews);
        }
        else {
            super.onReceive(context, intent);
        }

    }
}

