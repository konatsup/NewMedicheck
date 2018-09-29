package com.lifeistech.android.medicheck;

import java.util.Calendar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyAlarmManager {
    Context c;
    AlarmManager am;
    private PendingIntent mAlarmSender;

    public MyAlarmManager(Context c){
        this.c = c;
        am = (AlarmManager)c.getSystemService(Context.ALARM_SERVICE);;
    }

    public void addAlarm(){
        mAlarmSender = PendingIntent.getService(c, -1, new Intent(c, MyAlarmService.class), PendingIntent.FLAG_UPDATE_CURRENT);

//        // アラーム時間設定
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(System.currentTimeMillis());
//        cal.add(Calendar.MINUTE, 1);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        Log.v("MyAlarmManagerログ",cal.getTimeInMillis()+"ms");
//        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), mAlarmSender);
//        Log.v("MyAlarmManagerログ","アラームセット完了");
    }
}