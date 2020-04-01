package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

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
        setContentView(R.layout.activity_game);

        timer = findViewById(R.id.timer);

//        set the initial timer to 5 seconds
        timer.setMax(startTime);
        timer.setProgress(startTime);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTime = currentTime - 100;
                timer.setProgress(currentTime);
                if (currentTime > 0) {
                    handler.postDelayed(runnable, 100);
                    }
                }
            };
        handler.postDelayed(runnable, 100);
        }


}