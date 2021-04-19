package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.MediaController;
import android.widget.VideoView;


public class HelpActivity extends AppCompatActivity {



    VideoView myVideo;
    private MediaController media_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        myVideo = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoclip);

        media_control = new MediaController(this);

        myVideo.setMediaController(media_control);

        myVideo.setVideoURI(uri);

        myVideo.start();

    }
}