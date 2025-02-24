package com.example.maknaetest.timerdata;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver;
import com.example.maknaetest.createtimer.DayUtil;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.RECURRING;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.FRIDAY;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.MONDAY;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.SATURDAY;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.SUNDAY;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.THURSDAY;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.TUESDAY;
import static com.example.maknaetest.broadcastreceiver.TimerBroadcastReceiver.WEDNESDAY;

// ROOM을 이용한 테이블 이름 지정
@Entity(tableName = "timer_table")
public class Timer {
    // timerId를 기본키로 지정
    @PrimaryKey
    @NonNull
    private int timerId;

    // 시간, 분
    private int hour, minute;
//    private boolean started, recurring;
    private boolean started;
    private boolean monday, tuesday, wednesday, thursday, friday, saturday, sunday;
//    private String contents;
    // 커튼 1의 높이, 커튼 2의 높이, 조명의 색상(과연 int로 반환하는 것이 맞는가..?) (설정자, 접근자 만들어야 함.)
//    private int curtain1, curtain2, light;
//    private boolean curtain1_status, curtain2_status, curtain3_status ;

    private long created;

    public Timer(int timerId, int hour, int minute, boolean started, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
        this.timerId = timerId;
        this.hour = hour;
        this.minute = minute;
        this.started = started;

//        this.recurring = recurring;

        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;

        this.created = created;
    }

    /**
    public Timer(int timerId, int hour, int minute, boolean started, boolean recurring, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, boolean curtain1_status, boolean curtain2_status, boolean light_status) {
        this.timerId = timerId;
        this.hour = hour;
        this.minute = minute;
        this.started = started;

        this.recurring = recurring;

        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;

        this.created = created;
    }
     */

//    public Timer(int timerId, int hour, int minute, boolean started, boolean recurring, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, boolean curtain1_status) {
//        this.timerId = timerId;
//        this.hour = hour;
//        this.minute = minute;
//        this.started = started;
//
//        this.recurring = recurring;
//
//        this.monday = monday;
//        this.tuesday = tuesday;
//        this.wednesday = wednesday;
//        this.thursday = thursday;
//        this.friday = friday;
//        this.saturday = saturday;
//        this.sunday = sunday;
//
//        this.created = created;
//    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isStarted() {
        return started;
    }

    public int getTimerId() {
        return timerId;
    }

    public void setTimerId(int timerId) {
        this.timerId = timerId;
    }

    public boolean isMonday() {
        return monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    /** 여기부터는 예제에서 가져온 부분을 수정하기 전에 백업? 식으로 만들어둔 곳입니다. (삭제 요망.)
    public void schedule(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, TimerBroadcastReceiver.class);
        intent.putExtra(RECURRING, recurring);
        intent.putExtra(MONDAY, monday);
        intent.putExtra(TUESDAY, tuesday);
        intent.putExtra(WEDNESDAY, wednesday);
        intent.putExtra(THURSDAY, thursday);
        intent.putExtra(FRIDAY, friday);
        intent.putExtra(SATURDAY, saturday);
        intent.putExtra(SUNDAY, sunday);

        intent.putExtra(TITLE, contents);

        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(context, timerId, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 이 아래 수정해야 할 듯 ㅠㅠ
        // if alarm time has already passed, increment day by 1
        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        }

        if (!recurring) {
            String toastText = null;
            try {
                toastText = String.format("One Time Alarm %s scheduled for %s at %02d:%02d", contents, DayUtil.toDay(calendar.get(Calendar.DAY_OF_WEEK)), hour, minute, timerId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();

            alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    alarmPendingIntent
            );
        } else {
            String toastText = String.format("Recurring Alarm %s scheduled for %s at %02d:%02d", contents, getRecurringDaysText(), hour, minute, timerId);
            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();

            final long RUN_DAILY = 24 * 60 * 60 * 1000;
            alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    RUN_DAILY,
                    alarmPendingIntent
            );
        }

        this.started = true;
    }

    public void cancelTimer(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TimerBroadcastReceiver.class);
        PendingIntent timerPendingIntent = PendingIntent.getBroadcast(context, timerId, intent, 0);
        alarmManager.cancel(timerPendingIntent);
        this.started = false;

        String toastText = String.format("Timer cancelled for %02d:%02d with id %d", hour, minute, timerId);
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        Log.i("cancel", toastText);
    }


    public String getRecurringDaysText() {
        if (!recurring) {
            return null;
        }

        String days = "";
        if (monday) {
            days += "Mo ";
        }
        if (tuesday) {
            days += "Tu ";
        }
        if (wednesday) {
            days += "We ";
        }
        if (thursday) {
            days += "Th ";
        }
        if (friday) {
            days += "Fr ";
        }
        if (saturday) {
            days += "Sa ";
        }
        if (sunday) {
            days += "Su ";
        }

        return days;
    }

    public String getContents() {
        return contents;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
     */

    /**
    // 요일 반복을 하는지를 확인하기 위해 만든 메소드, 그런데 이 Timer 클래스쪽에서는 필요가 없고, TimerAddAcitivity에서 필요할듯.
    public void boolRecurring(){
        if (monday | tuesday | wednesday | thursday | friday | saturday | sunday){
            recurring = true;
        }else {
            recurring = false;
        }
    }
     */

    // 알람 매니저를 통해 서비스를 제공해주는 schedule() 정의
    public void schedule(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(context, TimerBroadcastReceiver.class);
//        intent.putExtra(RECURRING, recurring);
        intent.putExtra(MONDAY, monday);
        intent.putExtra(TUESDAY, tuesday);
        intent.putExtra(WEDNESDAY, wednesday);
        intent.putExtra(THURSDAY, thursday);
        intent.putExtra(FRIDAY, friday);
        intent.putExtra(SATURDAY, saturday);
        intent.putExtra(SUNDAY, sunday);

//        intent.putExtra(TITLE, contents);

        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(context, timerId, intent, 0);
        // Calendar.getInstance()로 현재 시간을 담고 있는 Calendar 객체를 리턴해 calendar 변수에 넣음.
        Calendar calendar = Calendar.getInstance();
        // (프로그램의)현재 시간을 calendar 변수에 넣음.
        calendar.setTimeInMillis(System.currentTimeMillis());
        // calendar 변수가 가지고 있는 HOUR_OF_Day 필드의 값을 hour가 가진 값으로 대체. (이하 같음.)
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // if alarm time has already passed, increment day by 1 (알람시간이 이미 지나갔다면(알람 울렸으면) 하루를 증가시킴.)
        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        }

        // 만약 요일 반복이 없다면
//        if (!recurring) {
//            String toastText = null;
//            try {
//                toastText = String.format("One Time Alarm %s scheduled for %s at %02d:%02d", DayUtil.toDay(calendar.get(Calendar.DAY_OF_WEEK)), hour, minute, timerId);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
//
//            alarmManager.setExact(
//                    AlarmManager.RTC_WAKEUP,
//                    calendar.getTimeInMillis(),
//                    alarmPendingIntent
//            );
//        } else {
//            String toastText = String.format("Recurring Alarm %s scheduled for %s at %02d:%02d", getRecurringDaysText(), hour, minute, timerId);
//            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
//
//            final long RUN_DAILY = 24 * 60 * 60 * 1000;
//            alarmManager.setRepeating(
//                    AlarmManager.RTC_WAKEUP,
//                    calendar.getTimeInMillis(),
//                    RUN_DAILY,
//                    alarmPendingIntent
//            );
//        }

        this.started = true;
    }

    public void cancelTimer(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TimerBroadcastReceiver.class);
        PendingIntent timerPendingIntent = PendingIntent.getBroadcast(context, timerId, intent, 0);
        alarmManager.cancel(timerPendingIntent);
        this.started = false;

        String toastText = String.format("Timer cancelled for %02d:%02d with id %d", hour, minute, timerId);
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        Log.i("cancel", toastText);
    }


    public String getRecurringDaysText() {
//        if (!recurring) {
//            return null;
//        }

        String days = "";

        if (sunday) {
            days += "일 ";
        }
        if (monday) {
            days += "월 ";
        }
        if (tuesday) {
            days += "화 ";
        }
        if (wednesday) {
            days += "수 ";
        }
        if (thursday) {
            days += "목 ";
        }
        if (friday) {
            days += "금 ";
        }
        if (saturday) {
            days += "토 ";
        }

        return days;
    }

//    public String getContents() {
//        return contents;
//    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
