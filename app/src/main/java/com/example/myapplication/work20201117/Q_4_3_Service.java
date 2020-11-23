package com.example.myapplication.work20201117;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Q_4_3_Service extends Service {

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder{
        Q_4_3_Service getService(){
            return Q_4_3_Service.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "本地绑定", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    public boolean onUnBind(Intent intent){
        Toast.makeText(this, "取消本地绑定", Toast.LENGTH_SHORT).show();
        return false;
    }


    public String IntCompare(String a, String b){
        int c=0;
        if (Integer.parseInt(a) > Integer.parseInt(b)){
            c = Integer.parseInt(a);
        }else {
            c = Integer.parseInt(b);
        }
        return "最大值为:" + c;
    }
}
