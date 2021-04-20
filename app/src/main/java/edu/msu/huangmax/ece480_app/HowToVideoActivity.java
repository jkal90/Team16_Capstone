package edu.msu.huangmax.ece480_app;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class HowToVideoActivity extends AppCompatActivity {



    VideoView myVideo;
    private MediaController media_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_intro);


        myVideo = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoclip2);

        media_control = new MediaController(this);

        myVideo.setMediaController(media_control);

        myVideo.setVideoURI(uri);

        myVideo.start();

    }

}


