package com.example.maknaetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.bluetooth.BluetoothAdapter;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;




//픽버튼 클릭시 확장 화면

public class Pick_Activity extends AppCompatActivity {

    private ImageView img;
    private BluetoothSPP bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_pick);
        img = (ImageView) findViewById(R.id.pickthumbnail); // img변수에 activity_ai_pick.xml 안 cardthumbnail 이미지뷰를 저장
        img.setImageResource(R.drawable.charactor); // activity_ai_pick.xml 안 배경이미지(cardthumbnail 아이디를 가진 이미지 뷰)에 이미지 설정
        img.setImageAlpha(0x80); //배경이미지를 16진수로 투명도 지정(배경위에 작성되는 글자가 더 잘보이게 하기 위함)

        bt = new BluetoothSPP(this); //Initializing

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() { //데이터 수신
            public void onDataReceived(byte[] data, String message) {
                Toast.makeText(Pick_Activity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


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
                setup();
            }
        }
    }

    public void setup() {
        ImageButton btnSend = findViewById(R.id.player_ai_btn); //데이터 전송
//        int state; // 시간 상태 변수
        String state; // 시간 상태 변수
        //현재시간을 가져오는 코드
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("hh");
        String getTime = simpleDate.format(mDate);
        int hour = Integer.parseInt(getTime);
        // 가져온 시간을 아침 점심 저녁 새벽으로 나누는 작업
        if (hour>=7 && hour<=11)
//            state = 0xa1;//아침
            state = "아침";
        else if (hour>=12 && hour<=16)
            state = "점심";
        else if (hour>=17 && hour<=23)
            state = "저녁";
        else  state = "새벽";

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bt.send(state, true);
            }
        });
    }


}
