package com.example.maknaetest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import com.example.maknaetest.timerservice.RescheduleTimersService;
import com.example.maknaetest.timerservice.TimerService;

import java.util.Calendar;

// 브로드캐스트 리시버는 안드로이드 OS에서 발생하는 각종 이벤트, 정보 가져와 핸들링하는 구성요소.
// 스마트폰을 껐다가 켜도 설정해놓은 타이머의 정보가 날아가지않도록하기위해 사용.
public class TimerBroadcastReceiver extends BroadcastReceiver {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "SUNDAY";
    public static final String RECURRING = "RECURRING";
//    public static final String TITLE = "TITLE";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 스마트폰 재부팅시, 안드로이드 OS에서 ACTION_BOOT_COMPLETED확인후 브로드캐스트해줌. (즉, 부팅을 했을 경우라면 토스트 띄우고, 서비스 만들어라.)
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "TimerBroadcastReceiver 작동.", Toast.LENGTH_SHORT).show();
            startRescheduleTimersService(context);
        }
        else {
            // 혹시나 그렇지 않다면 인텐트의 부가 정보들을 확인함.
            String toastText = String.format("Timer Received");
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            if (!intent.getBooleanExtra(RECURRING, false)) {
                startTimerService(context, intent);
            } {
                if (timerIsToday(intent)) {
                    startTimerService(context, intent);
                }
            }
        }
    }

    //
    private boolean timerIsToday(Intent intent) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int today = calendar.get(Calendar.DAY_OF_WEEK);

        switch(today) {
            case Calendar.MONDAY:
                if (intent.getBooleanExtra(MONDAY, false))
                    return true;
                return false;
            case Calendar.TUESDAY:
                if (intent.getBooleanExtra(TUESDAY, false))
                    return true;
                return false;
            case Calendar.WEDNESDAY:
                if (intent.getBooleanExtra(WEDNESDAY, false))
                    return true;
                return false;
            case Calendar.THURSDAY:
                if (intent.getBooleanExtra(THURSDAY, false))
                    return true;
                return false;
            case Calendar.FRIDAY:
                if (intent.getBooleanExtra(FRIDAY, false))
                    return true;
                return false;
            case Calendar.SATURDAY:
                if (intent.getBooleanExtra(SATURDAY, false))
                    return true;
                return false;
            case Calendar.SUNDAY:
                if (intent.getBooleanExtra(SUNDAY, false))
                    return true;
                return false;
        }
        return false;
    }

    // 재부팅 되었을 때, 실행될 안드로이드 Service
    private void startTimerService(Context context, Intent intent) {
        Intent intentService = new Intent(context, TimerService.class);
//        intentService.putExtra(TITLE, intent.getStringExtra(TITLE));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intentService);
        } else {
            context.startService(intentService);
        }
    }

    private void startRescheduleTimersService(Context context) {
        Intent intentService = new Intent(context, RescheduleTimersService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intentService);
        } else {
            context.startService(intentService);
        }
    }
}
