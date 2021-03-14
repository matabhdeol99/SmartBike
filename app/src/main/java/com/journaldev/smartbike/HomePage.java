package com.journaldev.smartbike;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

    }

    public void sendMap(View view) {
        Intent intent = new Intent(this, Maps.class);
        startActivity(intent);

    }

    public void sendCamera(View view) {
        Intent intent2 = new Intent(this, Camera.class);
        startActivity(intent2);
    }

    public void sendLighting(View view) {
        Intent intent2 = new Intent(this, LightControls.class);
        startActivity(intent2);

    }

    public void sendSettings(View view) {
        Intent intent2 = new Intent(this, Settings.class);
        startActivity(intent2);

    }

    public void sendHome(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void sendLogout(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}

