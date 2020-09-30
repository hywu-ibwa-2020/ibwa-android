package com.example.maknaetest;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCurtain extends Fragment {
    // 아직 커튼 활성화, 비활성화 설정 코드 없음.
    // 아직 커튼 위, 아래 버튼 설정 코드 없음.
    // 아직 조명바 온오프 설정 코드 없음.
    // 아직 컬러픽커를 통한 조명바 색상 변경 코드 없음.


    ImageButton lightPower_btn;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View curtain_view =  inflater.inflate(R.layout.fragment_curtain, container, false);

//        lightPower_btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return curtain_view;
    }
}