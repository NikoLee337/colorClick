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
    View btn_00, btn_01, btn_10, btn_11;
    ImageView toBeMatch;
    TextView level;

    private final static int COLOR_RED = 1;
    private final static int COLOR_ORANGE = 2;
    private final static int COLOR_YELLOW = 3;
    private final static int COLOR_GREEN = 4;
    private final static int COLOR_BLUE = 5;
    private final static int COLOR_INDIGO = 6;
    private final static int COLOR_VIOLET = 7;
    int MATCH_COLOR = 1;

    int currentLevel = 1;

    //comment here
    Handler handler;
    Runnable runnable;
    ProgressBar timer;
    Random r;
    Dialog pause;
    View v;

    boolean rightColor = false;

    int currentTime = 5000;
    int startTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//        //color button ids
        btn_00 = findViewById(R.id.button_00);
//        btn_01 = findViewById(R.id.button_01);
//        btn_10 = findViewById(R.id.button_10);
//        btn_11 = findViewById(R.id.button_11);
        toBeMatch = findViewById(R.id.imageView_color);
        toBeMatch.setClickable(false);
//        //text variable for level
//        level = findViewById(R.id.textView_level1);
//
//        //display the level
//        level.setText("Level " + currentLevel);
//
//        //randomize the matched color
//        r = new Random();
//        MATCH_COLOR = r.nextInt(7) + 1;
//        setMatchColor(MATCH_COLOR);

        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( btn_00.equals(toBeMatch)) {
                    btn_00.setVisibility(View. INVISIBLE);


                }
                setContentView(R.layout.activity_game2);
            }
        });

        /////////////////////////////////////////////////////////////

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

    //display the random color for player to match
//    private void setMatchColor (int startColor) {
//        switch (startColor) {
//            case COLOR_RED:
//                toBeMatch.setImageResource(R.drawable.red1);
//                currentLevel = COLOR_RED;
//                break;
//            case COLOR_ORANGE:
//                toBeMatch.setImageResource(R.drawable.orange1);
//                currentLevel = COLOR_ORANGE;
//                break;
//            case COLOR_YELLOW:
//                toBeMatch.setImageResource(R.drawable.yellow1);
//                currentLevel = COLOR_YELLOW;
//                break;
//            case COLOR_GREEN:
//                toBeMatch.setImageResource(R.drawable.green1);
//                currentLevel = COLOR_GREEN;
//                break;
//            case COLOR_BLUE:
//                toBeMatch.setImageResource(R.drawable.blue1);
//                currentLevel = COLOR_BLUE;
//                break;
//            case COLOR_INDIGO:
//                toBeMatch.setImageResource(R.drawable.indigo1);
//                currentLevel = COLOR_INDIGO;
//                break;
//            case COLOR_VIOLET:
//                toBeMatch.setImageResource(R.drawable.violet1);
//                currentLevel = COLOR_VIOLET;
//                break;
//        }
//    }



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