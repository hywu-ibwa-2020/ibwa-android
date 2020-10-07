package com.example.maknaetest;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCurtain extends Fragment {
    // 아직 커튼 활성화, 비활성화 설정 코드 없음.
    // 아직 커튼 위, 아래 버튼 설정 코드 없음.





    ImageButton lightPower_btn;
    Button lightbar_btn;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View curtain_view =  inflater.inflate(R.layout.fragment_curtain, container, false);

        // 조도 상태 표시 기능
        int sun_state = 100; // 조도값으로 받아오는 값 저장
        ImageView lighting = (ImageView) curtain_view.findViewById(R.id.lighting);

        if (sun_state >= 100 && sun_state < 300) //조도값이 100~300이면 좋음 값 출력
            lighting.setImageResource(R.drawable.lighting_blue);
        else if (sun_state > 301 && sun_state < 500) //조도값이 301~500이면 보통 값 출력
            lighting.setImageResource(R.drawable.lighting_green);
        else //조도값이 500초과이면 나쁨 값 출력
            lighting.setImageResource(R.drawable.lighting_red);

        // 조명바 온오프 설정 코드
        lightPower_btn = (ImageButton) curtain_view.findViewById(R.id.lightPower);
        lightPower_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { // 전원버튼 클릭시
                Button lightBar_btn = (Button) curtain_view.findViewById(R.id.lightBar);
                if (lightBar_btn.isClickable()==false) // 조명바 버튼이 꺼져있다면
                    lightBar_btn.setClickable(true);
                else // 조명바 버튼이 켜져있다면면
                   lightBar_btn.setClickable(false);

            }
        });
        // 조명바 클릭시 컬러피커 오픈
        lightbar_btn = (Button) curtain_view.findViewById(R.id.lightBar);
        lightbar_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { // 조명바 버튼 클릭시
                Toast.makeText(getActivity(), "컬러피커가 열립니다.", Toast.LENGTH_LONG).show();
            }
        });

        return curtain_view;
    }
}