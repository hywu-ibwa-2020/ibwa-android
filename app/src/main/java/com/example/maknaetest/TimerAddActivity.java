package com.example.maknaetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class TimerAddActivity extends AppCompatActivity {
    //프래그먼트
//    private FragmentManager fragmentManager = getSupportFragmentManager();
//    private FragmentTimerSelectCurtain1 fragmentTimerSelectCurtain1 = new FragmentTimerSelectCurtain1();
    ViewPager viewPager;
    LinearLayout linearLayout5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_add);

        // 선언부
        // 넘버피커 선언
        NumberPicker ap_num_picker =(NumberPicker)findViewById(R.id.ap_num_picker);     // 오전 오후
        NumberPicker hour_num_picker =(NumberPicker)findViewById(R.id.hour_num_picker); // 시
        NumberPicker min_num_picker =(NumberPicker)findViewById(R.id.min_num_picker);   // 분
        // 타이머 설정을 위한 커튼, 조명 텍스트뷰 선언
        TextView curtain1 = (TextView)findViewById(R.id.select_curtain1_textView);
        TextView curtain2 = (TextView)findViewById(R.id.select_curtain2_textView);
        TextView light = (TextView)findViewById(R.id.select_light_textView);
        // 프래그먼트
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        linearLayout5 = (LinearLayout)findViewById(R.id.linearLayout5);


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

        // 분 결정하는 넘버피커
        min_num_picker.setMinValue(00);
        min_num_picker.setMaxValue(59);
        min_num_picker.setOnLongPressUpdateInterval(100);


        // 커튼1, 2, 조명 탭을 위한 뷰페이저 셋팅.
        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        curtain1.setOnClickListener(movePageListener);
        curtain1.setTag(0);
        curtain2.setOnClickListener(movePageListener);
        curtain2.setTag(1);
        light.setOnClickListener(movePageListener);
        light.setTag(2);

        // 초기 프래그먼트 curtain1
        curtain1.setSelected(true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i = 0;
                while(i<3) {
                    if(position==i) {
                        linearLayout5.findViewWithTag(i).setSelected(true);
                    }
                    else {
                        linearLayout5.findViewWithTag(i).setSelected(false);
                    }
                    i++;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // 캔슬버튼 눌러서 액티비티 치우기.
        // 확인버튼 눌러서 액티비티 치우고 타이머 저장.
    }
    View.OnClickListener movePageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();
            int i = 0;
            while(i<3) {
                if(tag==i) {
                    linearLayout5.findViewWithTag(i).setSelected(true);
                }
                else {
                    linearLayout5.findViewWithTag(i).setSelected(false);
                }
                i++;
            }
            viewPager.setCurrentItem(tag);
        }
    };
    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new FragmentTimerSelectCurtain1();
                case 1:
                    return new FragmentTimerSelectCurtain2();
                case 2:
                    return new FragmentTimerSelectLight();
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            return 3;
        }
    }
}

