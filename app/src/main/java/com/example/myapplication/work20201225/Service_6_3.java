package com.example.myapplication.work20201225;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Service_6_3 extends Service implements Runnable {

    private static boolean threadRunning=false;
    public Service_6_3() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        threadRunning=true;
        new Thread(this).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        threadRunning=false;
    }

    @Override
    public void run() {
        while (threadRunning){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");// HH:mm:ss

            Date date = new Date(System.currentTimeMillis());
            String time = simpleDateFormat.format(date);
            Q_6_3.updateAppWidget(this,time);
            try{
                Thread.sleep(60000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
