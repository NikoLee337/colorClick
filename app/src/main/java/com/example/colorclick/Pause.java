package com.example.colorclick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pause extends AppCompatActivity {

    //Timer Variables
    TextView timer;
    public long counter = 5;
    public long counterRemaining;
    CountDownTimer count;
    ImageButton pauseButton;
    public long currentTime = 5000;
    public long goDownTime = 1000;
    public long temp = 0;
    Dialog pause;
    View v;

    public void startPause(){
        //INITIALIZE THE PAUSE VARIABLE
        pause = new Dialog(this);
        pauseButton = (ImageButton) findViewById(R.id.button_pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                //OPENS PAUSE MENU DIALOG
                pauseMenu(v);

                //CANCELS THE COUNT DOWN TIMER WHILE THE PAUSE MENU IS OPEN
                count.cancel();
            }
        });

        //CREATES AREA FOR TIMER ON GAME BOARD ON LOAD
        timer = (TextView) findViewById(R.id.timerView);

        //THE INITIAL COUNTDOWNTIMER IS CREATED UPON PLAYING THE GAME
        count = new CountDownTimer(currentTime, goDownTime) {
            public void onTick(long millisUntilFinished) {

                // Sets the timer area with the counter
                timer.setText(String.valueOf(counter));

                // Counter is deducted by 1 every second
                counter--;

                // Keeps track of the initial counter
                counterRemaining = counter;

                // Keeps track of the initial time left
                temp = millisUntilFinished;
            }

            //CALLS GAMEOVER PAGE ONCE TIMER RUNS OUT
            public void onFinish() {
                timer.setText("0");
                openGameOver();
            }
            //START THE TIMER
        }.start();
        //******************************************************//
    }

    //PAUSE MENU METHOD
    public void pauseMenu(View v) {
        TextView closebutton;
        TextView resume;

        // Brings up the dialog when the pause button is clicked
        pause.setContentView(R.layout.pause_menu);

        // Recreates a CountDownTimer with accurate time every time the 'X' button is clicked
        closebutton = (TextView) pause.findViewById(R.id.closebutton);
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Makes sure the counter is accurate upon resuming game
                counterRemaining++;

                // A new CountDownTimer is created upon closing the pause menu
                count = new CountDownTimer(temp, goDownTime) {
                    public void onTick(long millisUntilFinished) {

                        // Sets the timer area with the counter
                        timer.setText(String.valueOf((counterRemaining)));

                        // Tracks the time left
                        temp = millisUntilFinished;

                        // Counter is deducted by 1 every second
                        counterRemaining--;
                    }

                    // Calls GameOver page once time runs out
                    public void onFinish() {
                        timer.setText("0");
                        openGameOver();
                    }
                    // Starts the timer
                }.start();
                // Closes pause dialog
                pause.dismiss();
            }
        });

        // Recreates a CountDownTimer with accurate time every time the resume button is clicked
        resume = (Button) pause.findViewById(R.id.resumeButton);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Makes sure the counter is accurate upon resuming game
                counterRemaining++;

                // A new CountDownTimer is created upon closing the pause menu
                count = new CountDownTimer(temp, goDownTime) {
                    public void onTick(long millisUntilFinished) {

                        // Sets the timer area with the counter
                        timer.setText(String.valueOf((counterRemaining)));

                        // Tracks the time left
                        temp = millisUntilFinished;

                        // Counter is deducted by 1 every second
                        counterRemaining--;
                    }

                    // Calls GameOver page once time runs out
                    public void onFinish() {
                        timer.setText("0");
                        openGameOver();
                    }
                    // Starts the timer
                }.start();
                // Closes pause dialog
                pause.dismiss();
            }
        });
        //shows the popup menu
        pause.show();
    }//END OF PAUSE MENU

    //GAMEOVER SCREEN METHOD
    public void openGameOver() {
        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }//END OF GAMEOVER

}
