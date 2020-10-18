package com.example.maknaetest.timerservice;

import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.Observer;

import com.example.maknaetest.timerdata.Timer;
import com.example.maknaetest.timerdata.TimerRepository;

import java.sql.Time;
import java.util.List;

// 재부팅되었을 때, 잃어버린 AlarmManager 정보들을 다시 만들도록함.
public class RescheduleTimersService extends LifecycleService {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        TimerRepository timerRepository = new TimerRepository(getApplication());

        timerRepository.getTimersLiveData().observe(this, new Observer<List<Timer>>() {
            @Override
            public void onChanged(List<Timer> timers) {
                for (Timer a : timers) {
                    if (a.isStarted()) {
                        a.schedule(getApplicationContext());
                    }
                }
            }
        });

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        return null;
    }
}