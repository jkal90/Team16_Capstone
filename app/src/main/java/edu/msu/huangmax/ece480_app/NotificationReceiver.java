package edu.msu.huangmax.ece480_app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.
                getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeatingIntent = new Intent(context, RepeatingActivity.class);
        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100,
                repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context, "Light Therapy Notification");
        builder.setContentTitle("Time to do Light Therapy");
        builder.setSmallIcon(R.drawable.__clipart_sun_1);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        notificationManager.notify(100, builder.build());
    }
}
