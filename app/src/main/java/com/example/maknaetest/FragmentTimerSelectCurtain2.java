package com.example.maknaetest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;

public class FragmentTimerSelectCurtain2 extends Fragment {
    Switch switch1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View select_curtain2_view = inflater.inflate(R.layout.fragment_timer_select_curtain2, container, false);

        // 넘버픽커
        NumberPicker curtain2_picker = (NumberPicker)select_curtain2_view.findViewById(R.id.curtain_height);
        // 스위치
        switch1 = (Switch) select_curtain2_view.findViewById(R.id.switch1);

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
        curtain2_picker.setMinValue(0);
        curtain2_picker.setMaxValue(2);
        curtain2_picker.setFormatter(ap_formatter);
        curtain2_picker.setWrapSelectorWheel(false);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    //사용 상태일때 코드 여기 채워야함!!!!!!!!!!!!!!!!!!!!!
                } else {
                    //미사용 상태로 만들 시 코드
                    // 할 일.
                    // 1. 비활성화 시키기 (회색 불투명하게. 넘버픽커 안 움직이게.)
                }
            }
        });

        return select_curtain2_view;
    }
}