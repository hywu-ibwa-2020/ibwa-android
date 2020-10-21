package com.example.maknaetest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

//카드뷰 클릭시 확장 화면

public class Card_Activity extends AppCompatActivity {
    private BluetoothSPP bt;
    ToggleButton player_mood_btn;

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
        player_mood_btn = (ToggleButton) findViewById(R.id.player_mood_btn);

        bt = new BluetoothSPP(this); //Initializing

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() { //데이터 수신
            public void onDataReceived(byte[] data, String message) {
                Toast.makeText(Card_Activity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        player_mood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setup();
            }
        });




        // Recieve Data RecyclerViewAdapter 를 통해 받을 데이터
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title"); //안쓰는 코드
        String Description = intent.getExtras().getString("Description"); //안쓰는 코드
        int image = intent.getExtras().getInt("Thumbnail"); // RecyclerViewAdapter로 받아온 키값이 Thumbnail인 사진을 image 변수에 저장


        img.setImageResource(image); // activity_card.xml 안 배경이미지(cardthumbnail 아이디를 가진 이미지 뷰)에 image로 받아온 사진 매치
        img.setImageAlpha(0x80); //배경이미지를 16진수로 투명도 지정(배경위에 작성되는 글자가 더 잘보이게 하기 위함)




    }

    public void onStart(){
        super.onStart();
        if (!bt.isBluetoothEnabled()) { //
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, BluetoothState.REQUEST_ENABLE_BT);
        } else {
            if (!bt.isServiceAvailable()) {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_OTHER); //DEVICE_ANDROID는 안드로이드 기기 끼리
            }
        }
    }

    public void setup() {
        String mState;
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title"); //현재 화면의 title을 가져와 Title 변수에 저장
        String music = intent.getExtras().getString("Music_state");
        if (music=="m01") {
            mState = music;
        }else if(music=="m02") {
            mState = music;
        }else if(music=="m03") {
            mState = music;
        }else if(music=="m04") {
            mState = music;
        }else if(music=="m05") {
            mState = music;
        }else
            mState = music;

        if (player_mood_btn.isChecked())
            bt.send(mState, true);
        else
            bt.send("노래를멈춰줘", true);

    }


}
