package com.example.maknaetest.timerdata;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TimerRepository {
    private TimerDao timerDao;
    private LiveData<List<Timer>> timersLiveData;

    public TimerRepository(Application application) {
        TimerDatabase db = TimerDatabase.getDatabase(application);
        timerDao = db.timerDao();
        timersLiveData = timerDao.getTimers();
    }

    public void insert(Timer timer) {
        TimerDatabase.databaseWriteExecutor.execute(() -> {
            timerDao.insert(timer);
        });
    }

    public void update(Timer timer) {
        TimerDatabase.databaseWriteExecutor.execute(() -> {
            timerDao.update(timer);
        });
    }

    public LiveData<List<Timer>> getTimersLiveData() {
        return timersLiveData;
    }
}