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

import static com.example.colorclick.R.drawable.yellow1;

public class GameView extends AppCompatActivity {

    //buttons
    View btn_00, btn_10;
    View correct;
    ImageView correctColor;

    //comment here
    Handler handler;
    Handler overHandler;
    Runnable runnable;
    ProgressBar timer;
    Random random;
    Dialog pause;
    View v;

    //colors
    private final static int COLOR_RED = 1;
    private final static int COLOR_ORANGE = 2;
    private final static int COLOR_YELLOW = 3;
    private final static int COLOR_GREEN = 4;
    private final static int COLOR_BLUE = 5;
    private final static int COLOR_INDIGO = 6;
    private final static int COLOR_VIOLET = 7;

    Random r;
    int colorToBeMatched;

    boolean rightColor = false;

    int currentTime = 5000;
    int startTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //randomize colorToBeMatched
        r = new Random();
        colorToBeMatched = r.nextInt(7+1);
        setColorImage(colorToBeMatched);


        //color button ids
        correct = findViewById(R.id.imageView_color);
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


        //playGame();
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
        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }

    //plays the game
    public void playGame(View v) {
        correctColor(v);


    }

    //set color to be matched
    private void setColorImage(int match){
        switch (match){
            case COLOR_RED:
                correctColor.setImageResource(R.drawable.red1);
                colorToBeMatched = COLOR_RED;
                break;

            case COLOR_YELLOW:

                break;

            case COLOR_ORANGE:
                break;

            case COLOR_GREEN:
                break;

            case COLOR_BLUE:
                break;

            case COLOR_INDIGO:
                break;

            case COLOR_VIOLET:
                break;
        }
    }

    //correct color clicked method
    public void correctColor(View v) {
        btn_00.setVisibility(View.INVISIBLE);
    }
    //incorrect color clicked method
    public void incorrectColor(View v) {
        btn_00.setVisibility(View.VISIBLE);
    }

}