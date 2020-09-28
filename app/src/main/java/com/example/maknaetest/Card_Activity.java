package com.example.maknaetest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//카드뷰 클릭시 확장 화면

public class Card_Activity extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvcategory; // RecyclerViewAdapter 를 통해 넘어오는 데이터 담을 변수 선언
    private ImageView img, heart; // RecyclerViewAdapter 를 통해 넘어오는 담을 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_);

//        tvtitle = (TextView) findViewById(R.id.txttitle);
//        tvdescription = (TextView) findViewById(R.id.txtDesc);
//        tvcategory = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.cardthumbnail); // img변수에 activity_card.xml 안 cardthumbnail 이미지뷰를 저장
        heart = (ImageView) findViewById(R.id.card_heart);




        // Recieve Data RecyclerViewAdapter 를 통해 받을 데이터
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title"); //안쓰는 코드
        String Description = intent.getExtras().getString("Description"); //안쓰는 코드
        int image = intent.getExtras().getInt("Thumbnail"); // RecyclerViewAdapter로 받아온 키값이 Thumbnail인 사진을 image 변수에 저장


        //Setting values
//        tvtitle.setText(Title);
//        tvdescription.setText(Description);
        img.setImageResource(image); // activity_card.xml 안 배경이미지(cardthumbnail 아이디를 가진 이미지 뷰)에 image로 받아온 사진 매치
        img.setImageAlpha(0x80); //배경이미지를 16진수로 투명도 지정(배경위에 작성되는 글자가 더 잘보이게 하기 위함)




    }
}
