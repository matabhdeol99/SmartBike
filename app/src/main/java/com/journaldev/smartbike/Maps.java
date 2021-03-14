package com.journaldev.smartbike;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Maps extends AppCompatActivity {

    EditText etStartMap, etEndMap;
    Button btstartRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        etStartMap =findViewById(R.id.et_startMap);
        etEndMap =findViewById(R.id.et_endMap);
        btstartRoute =findViewById(R.id.bt_startMap);

        btstartRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sStartMap = etStartMap.getText().toString().trim();
                String sEndMap = etEndMap.getText().toString().trim();

                if (sStartMap.equals("") && sEndMap.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter a start and end point to start the route!", Toast.LENGTH_SHORT).show();
                }else{
                    DisplayTrack(sStartMap,sEndMap);
                }
            }
        });

    }

    public void DisplayTrack(String sStartMap , String sEndMap){

        try{
            Uri uri = Uri.parse ("https://www.google.co.in/maps/dir/" + sStartMap + "/" + sEndMap);

            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            intent.setPackage("com.google.android.apps.maps");

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);

        }catch(ActivityNotFoundException e){

            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");

            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }
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