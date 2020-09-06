package com.example.fapp;

import android.content.Intent;
import android.media.Image;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FappActivity extends AppCompatActivity {
    private TextView textLedig;
    private TextView textOpptatt;
    private final int romKapasitet = 55;
    private int seterLedig = romKapasitet;
    private int seterOpptatt = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOpptatt = findViewById(R.id.opptattCounter);
        textLedig = findViewById(R.id.ledigCounter);
        ImageView arriving = findViewById(R.id.arriving);
        ImageView leaving = findViewById(R.id.leaving);
        ImageView settings = findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FappActivity.this, SettingsActivity.class));
            }
        });

        arriving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapArriving();
            }
        });
        leaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapLeaving();
            }
        });
    }

    private void tapArriving() { //For arriving
        if(seterLedig>0 && seterOpptatt<romKapasitet) {
            seterOpptatt++;
            seterLedig--;
            textLedig.setText(String.format(String.valueOf(seterLedig)));
            textOpptatt.setText(String.format(String.valueOf(seterOpptatt)));
        }
    }
    private void tapLeaving() { //For leaving
        if(seterLedig<romKapasitet && seterOpptatt>0){
            seterOpptatt--;
            seterLedig++;
            textLedig.setText(String.format(String.valueOf(seterLedig)));
            textOpptatt.setText(String.format(String.valueOf(seterOpptatt)));
        }
    }
}