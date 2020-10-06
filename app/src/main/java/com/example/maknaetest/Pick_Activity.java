package com.example.maknaetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//픽버튼 클릭시 확장 화면

public class Pick_Activity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_pick);
        img = (ImageView) findViewById(R.id.pickthumbnail); // img변수에 activity_ai_pick.xml 안 cardthumbnail 이미지뷰를 저장
        img.setImageResource(R.drawable.charactor); // activity_ai_pick.xml 안 배경이미지(cardthumbnail 아이디를 가진 이미지 뷰)에 이미지 설정
        img.setImageAlpha(0x80); //배경이미지를 16진수로 투명도 지정(배경위에 작성되는 글자가 더 잘보이게 하기 위함)
    }

    // play_onclick 대한 로직
    public void play_ai_onclick(View view){

        String state; // 시간 상태 변수
        //현재시간을 가져오는 코드
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("hh");
        String getTime = simpleDate.format(mDate);
        int hour = Integer.parseInt(getTime);

        // 가져온 시간을 아침 점심 저녁 새벽으로 나누는 작업
        if (hour>=7 && hour<=11)
            state = "아침";
        else if (hour>=12 && hour<=16)
            state = "점심";
        else if (hour>=17 && hour<=23)
            state = "저녁";
        else state = "새벽";




        // LENGTH_LONG : 길게 화면에 나타남
        // LENGTH_SHORT : 짧게 화면에 나타남
        Toast.makeText(this, state+getTime, Toast.LENGTH_LONG).show();
    }
}
