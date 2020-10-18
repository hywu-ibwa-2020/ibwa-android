package com.example.maknaetest.timerdata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Room을 이용하여 Dao 사용
// Dao는 DB에 접근하는 메서드를 포함함. (데이터 삽입 삭제 갱신 등등..)
// Timer 테이블에 접근하기 위해 타이머객체를 삽입, 갱신, 쿼리문을 작성.

// @Dao 어노테이션을 사용해 Dao라고 명시함.
@Dao
public interface TimerDao {
    // 데이터 삽입
    @Insert
    void insert(Timer timer);

    // 모든 데이터 삭제
    @Query("DELETE FROM timer_table")
    void deleteAll();

    // timerId 기준 오름차순으로 정렬해서 timer_table의 모든 행들을 반환.
    @Query("SELECT * FROM timer_table ORDER BY timerId ASC")
    LiveData<List<Timer>> getTimers();

    // 데이터 갱신
    @Update
    void update(Timer timer);
}
