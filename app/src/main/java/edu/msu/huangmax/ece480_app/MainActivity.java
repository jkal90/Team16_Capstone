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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onPressWakeUpQuestions(View view) {
        Intent intent = new Intent(this, WakeUpQuestionsActivity.class);
        startActivity(intent);
    }

    public void onPressStartTimer(View view) {
        Intent intent = new Intent(this, StartTimerActivity.class);
        startActivity(intent);
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

    public void onPressNotifications(View view) {
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);
    }
}