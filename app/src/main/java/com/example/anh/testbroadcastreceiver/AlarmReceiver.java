package com.example.anh.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by anh on 01/09/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, AlarmService.class);
        context.startService(service1);
    }
}
