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

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button testNotifButton;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    private DatabaseTool databaseTool = new DatabaseTool();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testNotifButton = findViewById(R.id.getNotif);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Light Therapy Notification",
                    "Light Therapy Notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        testNotifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
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
                */
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this, "Light Therapy Notification");
                builder.setContentTitle("Time to do Light Therapy");
                builder.setSmallIcon(R.drawable.__clipart_sun_1);
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build());
            }
        });

    }
    public void onPressWakeUpQuestions(View view) {
        Intent intent = new Intent(this, WakeUpQuestionsActivity.class);
        startActivity(intent);
    }

    public void onPressStartTimer(View view) {
        Intent intent = new Intent(this, StartTimerActivity.class);
        startActivity(intent);

        Date date = new Date();
    }

    public void onPressNapQuestions(View view) {
        Intent intent = new Intent(this, NapQuestionsActivity.class);
        startActivity(intent);
    }

    public void onPressBedtimeQuestions(View view) {
        Intent intent = new Intent(this, BedtimeQuestionsActivity.class);
        startActivity(intent);
    }

    public void onPressMyInfoQuestions(View view) {
        Intent intent = new Intent(this, MyInfoActivity.class);
        startActivity(intent);
    }

    public void onPressHelp(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}