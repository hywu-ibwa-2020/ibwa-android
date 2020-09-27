package com.example.maknaetest.timerservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class TimerService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

        // 아두이노에 정보 보냄.

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        // 흠...
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
