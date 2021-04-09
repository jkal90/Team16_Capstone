package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class ReminderActivity extends AppCompatActivity {

    Button setNotifButton;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        setNotifButton = findViewById(R.id.set_button);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Light Therapy Notification",
                    "Light Therapy Notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        setNotifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                // 8:00
                calendar.set(Calendar.HOUR_OF_DAY, 20);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);

                Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                intent.setAction("Time to do Light Therapy");
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                        1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        ReminderActivity.this, "Light Therapy Notification");
                builder.setContentTitle("Time to do Light Therapy");
                builder.setSmallIcon(R.drawable.__clipart_sun_1);
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(ReminderActivity.this);
                managerCompat.notify(1, builder.build());

                onSubmit();
            }
        });
    }

    public void onSubmit() {
        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }
}