package com.example.myapplication.work20201117;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Q_4_1_Service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）。
     * 如果服务已在运行，则不会调用此方法。该方法只被调用一次
     */
    @Override
    public void onCreate() {
//        System.out.println("创建服务!!");
        Toast.makeText(this, "创建服务>.<", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    /**
     * 每次通过startService()方法启动Service时都会被回调。
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        System.out.println("运行！运行！");
        Toast.makeText(this, "运行！运行！", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁时的回调
     */
    @Override
    public void onDestroy() {
//        System.out.println("服务销毁T.T");
        Toast.makeText(this, "服务销毁T.T", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
