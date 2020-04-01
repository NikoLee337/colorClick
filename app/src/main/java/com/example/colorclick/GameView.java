package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
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
    Dialog pause;
    //Dialog quit;

    int currentTime = 5000;
    int startTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timer = findViewById(R.id.timer);
        pause = new Dialog(this);
        //quit = new Dialog(this);

        //set the initial timer to 5 seconds
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

    //Pause Menu
    public void pauseMenu (View v) {
        TextView closebutton;

        pause.setContentView(R.layout.pause_menu);
        closebutton = (TextView) pause.findViewById(R.id.closebutton);

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause.dismiss();
            }
        });
        //pause.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pause.show();

    }

    //quits the game
    //public void quitGame (View v) {
    //    quit.setContentView(R.layout.activity_main);


    //    quit.show();
    //}

}