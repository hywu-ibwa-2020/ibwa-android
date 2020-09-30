package com.example.maknaetest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.Toast;

public class FragmentTimerSelectCurtain1 extends Fragment {
    // 선언
    Switch switch1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View select_curtain1_view = inflater.inflate(R.layout.fragment_timer_select_curtain1, container, false);

        // 넘버픽커 선언 및 정의
        NumberPicker curtain1_picker = (NumberPicker)select_curtain1_view.findViewById(R.id.curtain_height);
        // 스위치 정의 (사용 미사용을 선택하기위한 스위치)
        switch1 = (Switch) select_curtain1_view.findViewById(R.id.switch1);

//        int minValue = 0;
//        int maxValue = 100;
//        int step = 50;
//
//        String[] numberValues = new String[maxValue - minValue + 1];
//        for (int i = 0; i <= numberValues.length; i++) {
//            numberValues[i] = String.valueOf((minValue + i) * step);
//        }
//
//        curtain1_picker.setMinValue(minValue);
//        curtain1_picker.setMaxValue(maxValue);

        // 넘버픽커 포메터 만듦. (형식 지정해주는 거라고 생각하면 됨.)
        NumberPicker.Formatter ap_formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                switch (value){
                    case 0:
                        return "0";
                    case 1:
                        return "50";
                    case 2:
                        return "100";
                }
                return null;
            }
        };
        curtain1_picker.setMinValue(0);
        curtain1_picker.setMaxValue(2);
        curtain1_picker.setWrapSelectorWheel(false);
        // 포메터 적용.
        curtain1_picker.setFormatter(ap_formatter);

        // 스위치 상태 변화를 확인하는 리스너.
        switch1.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    //사용 상태일때 코드 여기 채워야함!!!!!!!!!!!!!!!!!!!!! (사용상태를 알리고 커튼의 높이 저장해서 보내기.)
                } else {
                    //미사용 상태로 만들 시 코드
                    // 할 일.
                    // 1. 비활성화 시키기 (회색 불투명하게. 넘버픽커 안 움직이게.)
                }
            }
        });

        return select_curtain1_view;
    }

}
