package com.example.maknaetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class TimerAddActivity extends AppCompatActivity {
    //프래그먼트
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTimerSelectCurtain1 fragmentTimerSelectCurtain1 = new FragmentTimerSelectCurtain1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_add);

        // 선언부
        // 넘버피커 선언
        NumberPicker ap_num_picker =(NumberPicker)findViewById(R.id.ap_num_picker);     // 오전 오후
        NumberPicker hour_num_picker =(NumberPicker)findViewById(R.id.hour_num_picker); // 시
        NumberPicker min_num_picker =(NumberPicker)findViewById(R.id.min_num_picker);   // 분
        // 타이머 설정을 위한 커튼, 조명 버튼 선언 (이거 모르겠음..ㅠㅠㅠ 내부 클래스라서 final 붙은 건데 이래도 잘 되나..? (질문!!!!!!))
        Button curtain1_btn = (Button)findViewById(R.id.select_curtain1_btn);
        Button curtain2_btn = (Button)findViewById(R.id.select_curtain2_btn);
        Button light_btn = (Button)findViewById(R.id.select_light_btn);
        // 프래그먼트
        // 색상 저장
        String select_color = "#fbd14b";
        String unselect_color = "#fffcf0";

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentTimerSelectCurtain1).commitAllowingStateLoss();

        // 오전 오후 결정하는 넘버피커 설정
        NumberPicker.Formatter ap_formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                switch (value){
                    case 0:
                        return "오전";
                    case 1:
                        return "오후";
                }
                return null;
            }
        };
        ap_num_picker.setMinValue(0);
        ap_num_picker.setMaxValue(1);
        ap_num_picker.setFormatter(ap_formatter);
        ap_num_picker.setWrapSelectorWheel(false);

        // 시간 결정하는 넘버피커
        hour_num_picker.setMinValue(1);
        hour_num_picker.setMaxValue(12);
        hour_num_picker.setOnLongPressUpdateInterval(100);

        // 분 결정하는 넘버피커커
        min_num_picker.setMinValue(00);
        min_num_picker.setMaxValue(59);
        min_num_picker.setOnLongPressUpdateInterval(100);


        // 커튼1 버튼이 눌렸을 때,
        curtain1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // 커튼2 버튼이 눌렸을 때,
        curtain2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 조명 버튼이 눌렸을 때,
        light_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}

