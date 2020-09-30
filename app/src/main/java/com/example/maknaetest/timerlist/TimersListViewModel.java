package com.example.maknaetest.timerlist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.maknaetest.timerdata.Timer;
import com.example.maknaetest.timerdata.TimerRepository;

import java.util.List;

public class TimersListViewModel extends AndroidViewModel {
    private TimerRepository timerRepository;
    private LiveData<List<Timer>> timersLiveData;

    public TimersListViewModel(@NonNull Application application) {
        super(application);

        timerRepository = new TimerRepository(application);
        timersLiveData = timerRepository.getTimersLiveData();
    }

    public void update(Timer timer) {
        timerRepository.update(timer);
    }

    public LiveData<List<Timer>> getTimersLiveData() {
        return timersLiveData;
    }
}