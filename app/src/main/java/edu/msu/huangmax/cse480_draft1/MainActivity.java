package edu.msu.huangmax.cse480_draft1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button testNotifButton;

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
}