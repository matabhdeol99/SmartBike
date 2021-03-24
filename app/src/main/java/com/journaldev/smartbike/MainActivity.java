package com.journaldev.smartbike;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.journaldev.smartbike.R;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.mainactivity.radioGroupElection";

    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFormat(PixelFormat.UNKNOWN);



    }
    public void sendRegister(View view) {
        Intent intent = new Intent(this, Register.class);
            startActivity(intent);

    }

    public void sendLogin(View view) {
        Intent intent2 = new Intent(this, Login.class);
        startActivity(intent2);

    }
}