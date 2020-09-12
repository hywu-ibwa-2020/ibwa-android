package com.example.maknaetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTimer extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View timer_view =  inflater.inflate(R.layout.fragment_timer, container, false);

        // 타이머 추가 버튼
        Button timer_add_btn = (Button) timer_view.findViewById(R.id.timer_add_btn);
        // 타이머 추가 버튼 누르면 타이머 추가 액티비티로 이동.
        timer_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timer_add_intent = new Intent(getActivity(), TimerAddActivity.class);
                startActivity(timer_add_intent);
            }
        });

        return timer_view;
    }
}