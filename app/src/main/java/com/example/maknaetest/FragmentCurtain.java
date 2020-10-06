package com.example.maknaetest;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

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

        int sun_state = 100; // 조도값으로 받아오는 값 저장
        ImageView lighting = (ImageView) curtain_view.findViewById(R.id.lighting);

        if (sun_state > 100 && sun_state < 300) //조도값이 100~300이면 좋음 값 출력
            lighting.setImageResource(R.drawable.lighting_blue);
        else if (sun_state > 301 && sun_state < 500) //조도값이 301~500이면 보통 값 출력
            lighting.setImageResource(R.drawable.lighting_green);
        else //조도값이 500초과이면 나쁨 값 출력
            lighting.setImageResource(R.drawable.lighting_red);

//        lightPower_btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return curtain_view;
    }
}