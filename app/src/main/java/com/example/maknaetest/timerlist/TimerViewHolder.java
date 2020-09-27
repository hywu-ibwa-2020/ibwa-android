package com.example.maknaetest.timerlist;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maknaetest.R;
import com.example.maknaetest.timerdata.Timer;

// 뷰 홀더를 통해서 생성된 타이머들의 집합과 정보들을 저장.
public class TimerViewHolder extends RecyclerView.ViewHolder {
    // 선언 (타이머의 시간과 요일반복이 언제인지 정보들 필요.)
//    private TextView timerAp;
    private TextView timerTime;
//    private ImageView timerRecurring;
    private TextView timerRecurringDays;
//    private TextView TimerContents;
//    private TextView timerTitle;

    Switch timerStarted;

    // TimerViewHolder의 생성자. @NonNull은 null이 들어가면 경고가 뜨도록하는 주석과 비슷한 것임!
    public TimerViewHolder(@NonNull View itemView) {
        super(itemView);

        // 정의
//        timerAp = itemView.findViewById(R.id.item_timer_ap);
        timerTime = itemView.findViewById(R.id.item_timer_time);
        timerStarted = itemView.findViewById(R.id.item_timer_started);
//        timerRecurring = itemView.findViewById(R.id.item_timer_recurringDays);
        timerRecurringDays = itemView.findViewById(R.id.item_timer_recurringDays);
//        TimerContents = itemView.findViewById(R.id.item_timer_contents);
//        timerTitle = itemView.findViewById(R.id.item_alarm_title);
    }


    // 데이터 바인딩을 위한 bind() 정의. (이 부분도 더 공부가 필요할 것 같습니다..)
    public void bind(Timer timer, OnToggleTimerListener listener) {
        String timerText = String.format("%02d:%02d", timer.getHour(), timer.getMinute());

        timerTime.setText(timerText);
        timerStarted.setChecked(timer.isStarted());

        timerRecurringDays.setText(timer.getRecurringDaysText());


//        if (timer.isRecurring()) {
////            timerRecurring.setImageResource(R.drawable.ic_repeat_black_24dp);
//
//        } else {
////            timerRecurring.setImageResource(R.drawable.ic_looks_one_black_24dp);
//            timerRecurringDays.setText("Once Off");
//        }

//        if (timer.getContents().length() != 0) {
//            TimerContents.setText(timer.getContents());
//        } else {
//            TimerContents.setText("My timer");
//        }

        // 이 부분은 잘 모르겠습니다 ㅠㅠ...(어차피 onToggle()의 반환값이 void인데 만들어서 뭐하는 것이여)
        // 스위치를 클릭했을때 바꾸는 리스너니까 on/off 관련이긴할텐데 잘 모르겠습니다..
        timerStarted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.onToggle(timer);
            }
        });
    }
}