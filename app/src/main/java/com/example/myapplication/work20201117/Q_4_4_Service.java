package com.example.myapplication.work20201117;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import java.security.PublicKey;

public class Q_4_4_Service extends Service {

    private final Q_4_4_aidl.Stub mBinder = new Q_4_4_aidl.Stub() {
        public long Add(long a, long b) {
            return a + b;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "远程绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean  onUnbind  (Intent intent){
        Toast.makeText(this, "取消远程绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return false;
    }
}
