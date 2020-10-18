package com.example.maknaetest.timerlist;

import com.example.maknaetest.timerdata.Timer;

// FragmentTimerList.java 파일에서 구현해서 사용함.
// onToggle()을 오버라이딩해서 사용.
// 스위치가 가진 리스너. (스위치가 on이냐 off냐에 따라서..)
public interface OnToggleTimerListener  {
    void onToggle(Timer timer);
}