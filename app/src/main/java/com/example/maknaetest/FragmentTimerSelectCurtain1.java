package com.example.maknaetest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class FragmentTimerSelectCurtain1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View select_curtain_view = inflater.inflate(R.layout.fragment_timer_select_curtain1, container, false);

        // 넘버픽커
        NumberPicker curtain1_picker = (NumberPicker)select_curtain_view.findViewById(R.id.curtain_height);

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
        curtain1_picker.setFormatter(ap_formatter);

        return select_curtain_view;
    }

}
