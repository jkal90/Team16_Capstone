package edu.msu.huangmax.ece480_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void onStartIntro(View view) {
        Intent intent = new Intent(this, IntroVideoActivity.class);
        startActivity(intent);
    }

    public void onStartHow(View view) {
        Intent intent = new Intent(this, HowToVideoActivity.class);
        startActivity(intent);
    }
}
