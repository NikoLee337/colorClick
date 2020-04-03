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
    ImageButton btn_00, btn_01, btn_10, btn_11;
    ImageView toBeMatch;
    TextView level;

    private final static int B_00 = 1;
    private final static int B_01 = 2;
    private final static int B_10 = 3;
    private final static int B_11 = 4;
    int bPosition = B_00;

    private final static int COLOR_RED = 1;
    private final static int COLOR_ORANGE = 2;
    private final static int COLOR_YELLOW = 3;
    private final static int COLOR_GREEN = 4;
    private final static int COLOR_BLUE = 5;
    private final static int COLOR_INDIGO = 6;
    private final static int COLOR_VIOLET = 7;
    int matchColor = 1;

    int currentLevel = 1;

    //comment here
    Handler handler;
    Runnable runnable;
    ProgressBar timer;
    Random r1, r2;
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
//        btn_00 = findViewById(R.id.button_00);
//        btn_01 = findViewById(R.id.button_01);
//        btn_10 = findViewById(R.id.button_10);
//        btn_11 = findViewById(R.id.button_11);

        //color needed to be matched to other circles on the board
        toBeMatch = findViewById(R.id.imageView_color);
        toBeMatch.setClickable(false);

        //text variable for level
        level = findViewById(R.id.textView_level1);

        //display the level
        level.setText("Level " + currentLevel);

          //randomize the matched color
        r1 = new Random();
        matchColor = r1.nextInt(7) + 1;
        setMatchColor(matchColor);

        //generate board
        generateGameBoard(matchColor);

        //randomize buttons
        r2 = new Random();
        bPosition = r2.nextInt(4) + 1;


//        //method that moves to the next level
//        btn_00.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if ( btn_00.equals(toBeMatch)) {
//                    btn_00.setVisibility(View. INVISIBLE);
//
//                }
//                setContentView(R.layout.activity_game2);
//            }
//        });

        /////////////////////////////////////////////////////////////

        //initializes the pause variable
        pause = new Dialog(this);

        //find the timer/progressbar id
        timer = findViewById(R.id.timer_progressbar);

        //set the initial timer to 5 seconds
        timer.setMax(startTime);
        timer.setProgress(startTime);

        //handles the timer/progressbar countdown and main loop
        handler = new Handler();
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
    private int setMatchColor (int match) {
        switch (match) {
            case COLOR_RED:
                toBeMatch.setImageResource(R.drawable.red_footer);
                matchColor = COLOR_RED;
                break;
            case COLOR_ORANGE:
                toBeMatch.setImageResource(R.drawable.orange_footer);
                matchColor = COLOR_ORANGE;
                break;
            case COLOR_YELLOW:
                toBeMatch.setImageResource(R.drawable.yellow_footer);
                matchColor = COLOR_YELLOW;
                break;
            case COLOR_GREEN:
                toBeMatch.setImageResource(R.drawable.green_footer);
                matchColor = COLOR_GREEN;
                break;
            case COLOR_BLUE:
                toBeMatch.setImageResource(R.drawable.blue_footer);
                matchColor = COLOR_BLUE;
                break;
            case COLOR_INDIGO:
                toBeMatch.setImageResource(R.drawable.indigo1);
                matchColor = COLOR_INDIGO;
                break;
            case COLOR_VIOLET:
                toBeMatch.setImageResource(R.drawable.violet1);
                matchColor = COLOR_VIOLET;
                break;
        }
        return match;
    }

    //randomizes the colors around the board
    private void generateGameBoard(int correct) {

        int[] genBoardColor = { COLOR_RED, COLOR_ORANGE, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE, COLOR_INDIGO, COLOR_VIOLET};


        switch (correct) {
            case COLOR_RED:
                btn_00.setImageResource(R.drawable.red1);
                matchColor = COLOR_RED;

                break;
            case COLOR_ORANGE:
                btn_00.setImageResource(R.drawable.orange1);
                matchColor = COLOR_ORANGE;
                break;
            case COLOR_YELLOW:
                btn_00.setImageResource(yellow1);
                matchColor = COLOR_YELLOW;
                break;
            case COLOR_GREEN:
                btn_00.setImageResource(R.drawable.green1);
                matchColor = COLOR_GREEN;
                break;
            case COLOR_BLUE:
                btn_00.setImageResource(R.drawable.blue1);
                matchColor = COLOR_BLUE;
                break;
            case COLOR_INDIGO:
                btn_00.setImageResource(R.drawable.indigo1);
                matchColor = COLOR_INDIGO;
                break;
            case COLOR_VIOLET:
                btn_00.setImageResource(R.drawable.violet1);
                matchColor = COLOR_VIOLET;
                break;
        }

    }

    //randomizes the colors in an array
    public static int[] randomColorArray (int [] array) {
        Random rgen = new Random(); //generates random number

        for (int i = 0; i <array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
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

    }


    //correct color clicked method
    public void correctColor() {
        //btn_00.setVisibility(View.INVISIBLE);

    }
    //incorrect color clicked method
    public void incorrectColor(View v) {
        btn_00.setVisibility(View.VISIBLE);
    }

}