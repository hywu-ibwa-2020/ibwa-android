package com.example.maknaetest.timerservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

// 막내 앱을 사용하다가 다른 앱으로 이동해도 백그라운드에서 작업을 수행하기위해서 필요한 TimerService
// 타이머를 등록해두었을 때, 앱을 실행하고 있지않아도 커튼이 움직여야하기때문에! 사용.
// 타이머 서비스가 수행할 일을 정의해주면 됨. (아두이노에게 정보를 보내는 코드 작성하면 됨.)
public class TimerService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

        // 서비스가 만들어지면 가장 먼저 실행되는 onCreate() 메서드
        // 아두이노에게 정보를 보낼때, 사용해야하는 변수를 지정.

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        // 아두이노에 정보 보내는 코드 작성.
        return START_STICKY; // 플래그 뜻 찾아보기
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 아두이노 관련된 정보 보내는 거 변수들 없애거나 중지.
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
