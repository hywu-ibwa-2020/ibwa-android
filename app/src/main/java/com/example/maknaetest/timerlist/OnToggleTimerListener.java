package com.example.maknaetest.timerlist;

import com.example.maknaetest.timerdata.Timer;

// 이 인터페이스는 왜 필요한 것인지 잘 모르겠습니다..
// onToggle()이라는 메서드를 오버라이딩해 사용하게 하려고 만든것으로 추정은 됩니다. (근데 TimerViewHolder가서 보면 그냥 사용...?)
public interface OnToggleTimerListener  {
    void onToggle(Timer timer);
}