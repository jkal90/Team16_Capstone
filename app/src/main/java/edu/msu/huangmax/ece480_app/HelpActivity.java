package edu.msu.huangmax.ece480_app;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    //create class reference
    VideoView vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        vid = (VideoView)findViewById(R.id.videoView);

    }

    public void playVideo(View v) {
        MediaController m = new MediaController(this);
        vid.setMediaController(m);

        String path = "/edu.msu.huangmax/app/src/main/res/raw/videoclip.MOV";

        Uri u = Uri.parse(path);

        vid.setVideoURI(u);

        vid.start();

    }
}

