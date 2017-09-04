package com.example.anh.testbroadcastreceiver;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPickTime;
    private Calendar timeAlarm;
    public static int REQUEST_CODE = 0;
    public static int FLAG = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPickTime = (Button) findViewById(R.id.pick_time);
        btnPickTime.setOnClickListener(this);
        timeAlarm = Calendar.getInstance();
    }

    @Override
    public void onClick(View view) {
        TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
            @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                timeAlarm.set(Calendar.HOUR_OF_DAY,hour);
                timeAlarm.set(Calendar.MINUTE,minute);
            }
        };
        TimePickerDialog time = new TimePickerDialog(
                MainActivity.this,
                callback, 0, 0, true);
        time.show();
        Intent intent = new Intent(MainActivity.this,AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,REQUEST_CODE,intent,FLAG);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC,timeAlarm.getTimeInMillis(),pendingIntent);
    }
}
