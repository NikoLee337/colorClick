package com.example.colorclick;

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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameView2 extends AppCompatActivity {
    //buttons
    ImageButton btn_00, btn_01, btn_10, btn_11;
    ImageView matchTheColor;
    TextView level;
    Random r1, r2, r3;
    boolean rightColor = false;

    public final static int B_00 = 1;
    public final static int B_01 = 2;
    public final static int B_10 = 3;
    public final static int B_11 = 4;
    int corrButton = B_00; //correct button
    ArrayList<Integer> positions = new ArrayList<>(Arrays.asList(B_00, B_01, B_10, B_11));
    ArrayList<Integer> temp1; //TEMPORARY LIST TO STORE POSITIONS WITHOUT CORRECT POSITION(S)

    public final static int COLOR_RED = 1;
    public final static int COLOR_ORANGE = 2;
    public final static int COLOR_YELLOW = 3;
    public final static int COLOR_GREEN = 4;
    public final static int COLOR_BLUE = 5;
    public final static int COLOR_INDIGO = 6;
    public final static int COLOR_VIOLET = 7;
    int corrColor = 1;//correct color
    ArrayList<Integer> colors = new ArrayList<>(Arrays.asList(COLOR_RED, COLOR_ORANGE, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE, COLOR_INDIGO, COLOR_VIOLET));
    ArrayList<Integer> temp2; //TEMPORARY LIST TO STORE COLORS OTHER THAN CORRECT COLOR(S)


    int currentLevel = 2;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
//
//        GamePlayOLD gpOLD = new GamePlayOLD();
//        Pause pause = new Pause();


        //CREATED ON GAME BOARD ON LOAD
        //DEFAULT IMAGE BUTTONS
        btn_00 = findViewById(R.id.button_00);
        btn_01 = findViewById(R.id.button_01);
        btn_10 = findViewById(R.id.button_10);
        btn_11 = findViewById(R.id.button_11);

        //DEFAULT IMAGE BUTTON REPRESENTING THE COLOR TO BE MATCHED
        matchTheColor = findViewById(R.id.imageView_color);
        matchTheColor.setClickable(false);

        //DISPLAY LEVEL
//        level = findViewById(R.id.textView_level1);
//        level.setText("Level " + currentLevel);
        //******************************************************//

//        //method that moves to the next level
////        btn_01.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if ( btn_01.equals(matchTheColor)) {
////                    btn_01.setVisibility(View. INVISIBLE);
////                }
////                setContentView(R.layout.activity_game2);
////            }
////        });
//
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_game3);
                count.cancel();
                openGameView3();
            }
        });
//
//
//        //GENERATING COLORS AND POSITIONS
//        //GENERATE THE CORRECT COLOR
////        r1 = new Random();
////        corrColor = r1.nextInt(colors.size()) + 1;
////
////        //GENERATE THE CORRECT BUTTON LOCATION(S)
////        r2 = new Random();
////        corrButton = r2.nextInt(positions.size()) + 1;
////
////        gpOLD.setMatchColor(corrColor); //SET CORRECT COLOR
////        gpOLD.getMatchColor(corrColor); //GET CORRECT COLOR
////        gpOLD.getBoardPositionCorrect(corrButton, corrColor); //GET CORRECT POSITION(S) AND DISPLAY CORRECT COLOR
////        gpOLD.getBoardPositionIncorrect(corrButton, corrColor); //GET INCORRECT POSITIONS(S) AND DISPLAY INCORRECT COLORS
//        //******************************************************//
//
////        pause.startPause();
//
        //INITIALIZE THE PAUSE VARIABLE
        pause = new Dialog(this);
        pauseButton = (ImageButton) findViewById(R.id.button_pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
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
    }//END OF ON-CREATE
//    //******************************************************//
//
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

    // GAMEOVER SCREEN METHOD
    public void openGameOver() {
        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }//END OF GAMEOVER
//
//
//    public void playGame(View v) {
//
//    }
//
//    public void openGameView(View v) {
//        Intent intent = new Intent(this, GameView.class);
//        startActivity(intent);

        public void openGameView3(){
            Intent intent = new Intent(this, GameView3.class);
            startActivity(intent);
        }

//    }
}//END OF CLASS



