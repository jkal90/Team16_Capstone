package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


public class IntroVideoActivity extends AppCompatActivity {



    VideoView myVideo;
    private MediaController media_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_intro);


        myVideo = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoclip);

        media_control = new MediaController(this);

        myVideo.setMediaController(media_control);

        myVideo.setVideoURI(uri);

        myVideo.start();

    }

    public void onHowBack(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

}