package com.example.maknaetest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//픽버튼 클릭시 확장 화면

public class Pick_Activity extends AppCompatActivity {

    private ImageView img; // RecyclerViewAdapter 를 통해 넘어오는 담을 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_pick);

//        tvtitle = (TextView) findViewById(R.id.txttitle);
//        tvdescription = (TextView) findViewById(R.id.txtDesc);
//        tvcategory = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.pickthumbnail); // img변수에 activity_card.xml 안 cardthumbnail 이미지뷰를 저장

        img.setImageResource(R.drawable.charactor); // activity_card.xml 안 배경이미지(cardthumbnail 아이디를 가진 이미지 뷰)에 image로 받아온 사진 매치
        img.setImageAlpha(0x80); //배경이미지를 16진수로 투명도 지정(배경위에 작성되는 글자가 더 잘보이게 하기 위함)




    }
}
