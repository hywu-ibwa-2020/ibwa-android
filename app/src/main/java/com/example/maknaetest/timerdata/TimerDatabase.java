package com.example.maknaetest.timerdata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Timer.class}, version = 1, exportSchema = false)
public abstract class TimerDatabase extends RoomDatabase {
    public abstract TimerDao timerDao();

    private static volatile TimerDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TimerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TimerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TimerDatabase.class,
                            "timer_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}