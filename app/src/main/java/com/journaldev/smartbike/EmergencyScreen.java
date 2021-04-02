package com.journaldev.smartbike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class EmergencyScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencyscreen);

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