package com.example.maknaetest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

public class FragmentTimerSelectLight extends Fragment {
    Switch switch1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View select_light_view = inflater.inflate(R.layout.fragment_timer_select_light, container, false);

        // 스위치
        switch1 = (Switch) select_light_view.findViewById(R.id.switch1);

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

        return select_light_view;
    }
}