package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_enter);
    }
    public void onButtonPress(View view) {
        Intent intent = new Intent(this, SetIDActivity.class);
        startActivity(intent);
    }
}