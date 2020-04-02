package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class GameView extends AppCompatActivity {

    //buttons
    View btn_00;

    //comment here
    Handler handler;
    Handler overHandler;
    Runnable runnable;
    ProgressBar timer;
    Random random;
    Dialog pause;
    View v;

    boolean rightColor = false;

    int currentTime = 5000;
    int startTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //color button ids
        btn_00 = findViewById(R.id.button_00);


        //initializes the pause variable
        pause = new Dialog(this);

        //find the timer/progressbar id
        timer = findViewById(R.id.timer_progressbar);

        //set the initial timer to 5 seconds
        timer.setMax(startTime);
        timer.setProgress(startTime);

        //handler for the timer
        handler = new Handler();

        //runs and handles the progressbar/timer
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTime = currentTime - 100;
                timer.setProgress(currentTime);
                if (currentTime > 0) {
                    handler.postDelayed(runnable, 100);
                } else if (currentTime == 0) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            openGameOver();
                        }
                    }, 100);
                }
            }
        };
        handler.postDelayed(runnable, 100);
    }


    //pause menu method
    public void pauseMenu(View v) {
        TextView closebutton;

        pause.setContentView(R.layout.pause_menu);
        closebutton = (TextView) pause.findViewById(R.id.closebutton);
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause.dismiss();
            }
        });

        //shows the popup menu
        pause.show();
    }


    //open game over screen method
    public void openGameOver() {
        Intent intent = new Intent (this, GameOver.class);
        startActivity(intent);
    }


    //game play HERE
    public void playGame() {

    }

}