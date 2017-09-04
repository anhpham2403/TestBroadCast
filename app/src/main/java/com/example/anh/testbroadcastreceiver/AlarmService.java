package com.example.anh.testbroadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by anh on 01/09/2017.
 */

public class AlarmService extends Service {
    public static int ID = 1;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationManager notificationManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);
        PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),MainActivity.REQUEST_CODE, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "Go", pendingNotificationIntent).build();
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Hi")
                .setContentTitle("Opps")
                .addAction(action)
                .build();
        notificationManager.notify(ID, notification);
        return START_STICKY;
    }
}
