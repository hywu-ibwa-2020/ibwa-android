package com.example.maknaetest.createtimer;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.maknaetest.timerdata.Timer;
import com.example.maknaetest.timerdata.TimerRepository;

public class CreateTimerViewModel extends AndroidViewModel {
    private TimerRepository timerRepository;

    public CreateTimerViewModel(@NonNull Application application) {
        super(application);

        timerRepository = new TimerRepository(application);
    }

    public void insert(Timer timer) {
        timerRepository.insert(timer);
    }
}
