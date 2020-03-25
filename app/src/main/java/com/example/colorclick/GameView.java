package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class GameView extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    ProgressBar timer;
    Random random;

    int currentTime = 5000;
    int startTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        timer = findViewById(R.id.timer);

        //set the initial timer to 5 seconds
        timer.setMax(startTime);
        timer.setProgress(startTime);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTime = currentTime - 1000;
                timer.setProgress(currentTime);
                if (currentTime > 0) {
                    handler.postDelayed(runnable, 1000);
                    }
                }
            };
        handler.postDelayed(runnable, 1000);
        }


}