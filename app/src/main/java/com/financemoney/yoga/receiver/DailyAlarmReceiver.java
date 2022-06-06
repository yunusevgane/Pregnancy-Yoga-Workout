package com.financemoney.yoga.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

import com.financemoney.yoga.R;
import com.financemoney.yoga.Splash_actvity;

import static android.os.Build.VERSION_CODES.O;

public class DailyAlarmReceiver extends BroadcastReceiver {


    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= O) {
            NotificationChannel notificationChannel = null;
            if (Build.VERSION.SDK_INT >= O) {
                notificationChannel = new NotificationChannel("reminder_notification", "Reminder Notification", NotificationManager.IMPORTANCE_DEFAULT);
            }
            if (Build.VERSION.SDK_INT >= O) {
                notificationChannel.setDescription("Include all the notifications");
            }
            if (Build.VERSION.SDK_INT >= O) {
                ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(notificationChannel);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        createNotificationChannel(context);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.noto_banner);


        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(100, new NotificationCompat.Builder(context, "reminder_notification")


                        .setContentIntent(PendingIntent.getActivity(context, 100,
                                new Intent(context, Splash_actvity.class), 134217728))
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo))
                        .setSmallIcon(R.mipmap.ic_new_rest).setContentTitle("Hey! it's Now Workout time")
                        .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                        .setContentText("It's time to do Pregnancy Yoga Workout")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(decodeResource)
                                .setBigContentTitle("Hey! it's Now Workout time").setSummaryText("Let's get ready to do Pregnancy Yoga Exercise"))
                        .setAutoCancel(true).build());

    }
}
