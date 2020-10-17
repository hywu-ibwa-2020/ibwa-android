package com.example.maknaetest.createtimer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.maknaetest.FragmentTimerSelectCurtain1;
import com.example.maknaetest.FragmentTimerSelectCurtain2;
import com.example.maknaetest.FragmentTimerSelectLight;
import com.example.maknaetest.R;
import com.example.maknaetest.timerdata.Timer;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerAddActivity extends AppCompatActivity {

    // 선언
    ViewPager viewPager;
    LinearLayout linearLayout5;
    // 더 이상 사용하지 않는 ViewModelProviders.of을 대체하기 위해서 선언
    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;
    private ViewModelStore viewModelStore = new ViewModelStore();
    // butterKnife's @BindView로 선언 및 정의 (변수 선언과 정의를 더 쉽게 해주는 라이브러리)
    @BindView(R.id.time_picker) TimePicker timePicker;
    @BindView(R.id.sun_btn) ToggleButton sun;
    @BindView(R.id.mon_btn) ToggleButton mon;
    @BindView(R.id.tue_btn) ToggleButton tue;
    @BindView(R.id.wed_btn) ToggleButton wed;
    @BindView(R.id.thu_btn) ToggleButton thu;
    @BindView(R.id.fri_btn) ToggleButton fri;
    @BindView(R.id.sat_btn) ToggleButton sat;
    @BindView(R.id.cancel_btn) Button cancel_btn;
    @BindView(R.id.confirm_btn) Button confirm_btn;

    private CreateTimerViewModel createTimerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_add);
        ButterKnife.bind(this);

//        createTimerViewModel = ViewModelProviders.of(this).get(CreateTimerViewModel.class);
        // 위 코드를 더 이상 제공해주지않아서 사용이 불가능하기때문에 아래 코드로 변경.
        if (viewModelFactory == null){
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }
        createTimerViewModel = new ViewModelProvider(this, viewModelFactory).get(CreateTimerViewModel.class);

        // 선언부
//        // 넘버피커 선언
//        NumberPicker ap_num_picker =(NumberPicker)findViewById(R.id.ap_num_picker);     // 오전 오후
//        NumberPicker hour_num_picker =(NumberPicker)findViewById(R.id.hour_num_picker); // 시
//        NumberPicker min_num_picker =(NumberPicker)findViewById(R.id.min_num_picker);   // 분

        // 탭의 커튼, 조명 텍스트뷰 선언 및 정의 (탭을 위해)
        TextView curtain1 = (TextView)findViewById(R.id.select_curtain1_textView);
        TextView curtain2 = (TextView)findViewById(R.id.select_curtain2_textView);
        TextView light = (TextView)findViewById(R.id.select_light_textView);

        // 탭을 위한 뷰페이저와 레이아웃 정의
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        linearLayout5 = (LinearLayout)findViewById(R.id.linearLayout5);


//        // 오전 오후 결정하는 넘버피커 설정
//        NumberPicker.Formatter ap_formatter = new NumberPicker.Formatter() {
//            @Override
//            public String format(int value) {
//                switch (value){
//                    case 0:
//                        return "오전";
//                    case 1:
//                        return "오후";
//                }
//                return null;
//            }
//        };
//        ap_num_picker.setMinValue(0);
//        ap_num_picker.setMaxValue(1);
//        ap_num_picker.setFormatter(ap_formatter);
//        ap_num_picker.setWrapSelectorWheel(false);
//
//        // 시간 결정하는 넘버피커
//        hour_num_picker.setMinValue(1);
//        hour_num_picker.setMaxValue(12);
//        hour_num_picker.setOnLongPressUpdateInterval(100);
//
//        // 분 결정하는 넘버피커
//        min_num_picker.setMinValue(00);
//        min_num_picker.setMaxValue(59);
//        min_num_picker.setOnLongPressUpdateInterval(100);

        // 커튼1, 2, 조명 탭을 위한 뷰페이저 셋팅.
        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        // 각각의 탭(으로 사용할 텍스트뷰)에 태그를 붙여줌. (태그는 어느 뷰에나 붙일 수 있는 꼬리표 같은 것.)
        curtain1.setOnClickListener(movePageListener);
        curtain1.setTag(0);
        curtain2.setOnClickListener(movePageListener);
        curtain2.setTag(1);
        light.setOnClickListener(movePageListener);
        light.setTag(2);

        // 초기 프래그먼트 curtain1
        curtain1.setSelected(true);

        // 탭의 스와이프를 담당하는 리스너
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
        cancel_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//         확인버튼 눌러서 액티비티 치우고 타이머 저장.
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleTimer();
                finish();
//                Navigation.findNavController(v).navigate(R.id.action_createAlarmFragment_to_alarmsListFragment);
            }
        });
    }

    // 프래그먼트 변경을 위한 리스너 (뷰의 태그를 받아와서 i와 같으면 i에 해당하는 뷰를 레이아웃에 뿌려줌.)
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

    // 커튼1, 커튼2, 조명 설정을 위한 뷰페이저
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

    private void scheduleTimer() {
        int timerId = new Random().nextInt(Integer.MAX_VALUE);

        Timer timer = new Timer(
                timerId,
                TimePickerUtil.getTimePickerHour(timePicker),
                TimePickerUtil.getTimePickerMinute(timePicker),
                true,
//                boolRecurring(),
                mon.isChecked(),
                tue.isChecked(),
                wed.isChecked(),
                thu.isChecked(),
                fri.isChecked(),
                sat.isChecked(),
                sun.isChecked()
        );

        createTimerViewModel.insert(timer);

        timer.schedule(getApplicationContext());
    }

    // 요일 반복을 하는지를 확인하기 위해 만든 메소드
    public boolean boolRecurring(){
        if (mon.isChecked() | tue.isChecked() | wed.isChecked() | thu.isChecked()
                | fri.isChecked() | sat.isChecked() | sun.isChecked()){
            return true;
        }else {
            return false;
        }
    }

}

