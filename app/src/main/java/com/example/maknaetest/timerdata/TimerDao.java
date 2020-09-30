package com.example.maknaetest.timerdata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Room을 이용하여 Dao 사용
// Dao는 DB에 접근하는 메서드를 포함함. (데이터 삽입 삭제 갱신 등등..)
// 더 공부 필요.
@Dao
public interface TimerDao {
    @Insert
    void insert(Timer timer);

    @Query("DELETE FROM timer_table")
    void deleteAll();

    @Query("SELECT * FROM timer_table ORDER BY timerId ASC")
    LiveData<List<Timer>> getTimers();

    @Update
    void update(Timer timer);
}
