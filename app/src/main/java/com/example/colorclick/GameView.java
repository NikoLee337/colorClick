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

public class GameView extends AppCompatActivity {
    //buttons
    ImageButton btn_00, btn_01, btn_10, btn_11;
    ImageView matchTheColor;
    TextView level;
    Random r1, r2, r3;
    boolean rightColor = false;

    private final static int B_00 = 1;
    private final static int B_01 = 2;
    private final static int B_10 = 3;
    private final static int B_11 = 4;
    int corrButton = B_00; //correct button
    ArrayList<Integer> positions = new ArrayList<>(Arrays.asList(B_00, B_01, B_10, B_11));
    ArrayList<Integer> temp1; //TEMPORARY LIST TO STORE POSITIONS WITHOUT CORRECT POSITION(S)

    private final static int COLOR_RED = 1;
    private final static int COLOR_ORANGE = 2;
    private final static int COLOR_YELLOW = 3;
    private final static int COLOR_GREEN = 4;
    private final static int COLOR_BLUE = 5;
    private final static int COLOR_INDIGO = 6;
    private final static int COLOR_VIOLET = 7;
    int corrColor = 1;//correct color
    ArrayList<Integer> colors = new ArrayList<>(Arrays.asList(COLOR_RED, COLOR_ORANGE, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE, COLOR_INDIGO, COLOR_VIOLET));
    ArrayList<Integer> temp2; //TEMPORARY LIST TO STORE COLORS OTHER THAN CORRECT COLOR(S)

    int currentLevel = 1;


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
        setContentView(R.layout.activity_game);

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
        level = findViewById(R.id.textView_level1);
        level.setText("Level " + currentLevel);
        //******************************************************//

        //GENERATING COLORS AND POSITIONS
        //GENERATE THE CORRECT COLOR
        r1 = new Random();
        corrColor = r1.nextInt(colors.size()) + 1;

        //GENERATE THE CORRECT BUTTON LOCATION(S)
        r2 = new Random();
        corrButton = r2.nextInt(positions.size()) + 1;

        setMatchColor(corrColor); //SET CORRECT COLOR
        getMatchColor(corrColor); //GET CORRECT COLOR
        getBoardPositionCorrect(corrButton, corrColor); //GET CORRECT POSITION(S) AND DISPLAY CORRECT COLOR
        getBoardPositionIncorrect(corrButton, corrColor); //GET INCORRECT POSITIONS(S) AND DISPLAY INCORRECT COLORS
        //******************************************************//

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
    }//END OF ON-CREATE
    //******************************************************//

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

    //SET METHOD FOR MATCHING COLOR (colored image at BOTTOM-RIGHT-CORNER of screen)
    public int setMatchColor(int match) {
        switch (match) {
            case COLOR_RED:
                matchTheColor.setImageResource(R.drawable.red_footer);
                corrColor = COLOR_RED;
                break;
            case COLOR_ORANGE:
                matchTheColor.setImageResource(R.drawable.orange_footer);
                corrColor = COLOR_ORANGE;
                break;
            case COLOR_YELLOW:
                matchTheColor.setImageResource(R.drawable.yellow_footer);
                corrColor = COLOR_YELLOW;
                break;
            case COLOR_GREEN:
                matchTheColor.setImageResource(R.drawable.green_footer);
                corrColor = COLOR_GREEN;
                break;
            case COLOR_BLUE:
                matchTheColor.setImageResource(R.drawable.blue_footer);
                corrColor = COLOR_BLUE;
                break;
            case COLOR_INDIGO:
                matchTheColor.setImageResource(R.drawable.indigo_footer);
                corrColor = COLOR_INDIGO;
                break;
            case COLOR_VIOLET:
                matchTheColor.setImageResource(R.drawable.violet_footer);
                corrColor = COLOR_VIOLET;
                break;
        }
        return match;
    }//END OF MATCH COLOR SETTER

    //GET METHOD FOR MATCHING COLOR
    public void getMatchColor(int correct) {
        switch (correct) {
            case COLOR_RED:
                corrColor = COLOR_RED;
                break;
            case COLOR_ORANGE:
                corrColor = COLOR_ORANGE;
                break;
            case COLOR_YELLOW:
                corrColor = COLOR_YELLOW;
                break;
            case COLOR_GREEN:
                corrColor = COLOR_GREEN;
                break;
            case COLOR_BLUE:
                corrColor = COLOR_BLUE;
                break;
            case COLOR_INDIGO:
                corrColor = COLOR_INDIGO;
                break;
            case COLOR_VIOLET:
                corrColor = COLOR_VIOLET;
                break;

        }

    }//END OF MATCH COLOR GETTER

    //GET METHOD FOR DISPLAYING CORRECT COLOR(S) ON BOARD
    public void getBoardPositionCorrect(int pos, int color) {
        switch (pos) {
            case B_00:
                getButton_00(color);
                corrButton = B_00;
                break;
            case B_01:
                getButton_01(color);
                corrButton = B_01;
                break;
            case B_10:
                getButton_10(color);
                corrButton = B_10;
                break;
            case B_11:
                getButton_11(color);
                corrButton = B_11;
        }
    }//END OF getBPC GETTER

    public void getTemp1List(int posi) {
        for (int i = 0; i < positions.size(); i++) {
            if (positions.contains(posi) && positions.get(i) == posi) {
                positions.remove(i);
                temp1 = new ArrayList<>(positions);
                break;
            }
        }
    }

    public void getTemp2List(int color) {
        for (int j = 0; j < colors.size(); j++) {
            if (colors.contains(color) && colors.get(j) == color) { //color = 5 at index of 4
                colors.remove(j);
                temp2 = new ArrayList<>(colors);
                break;
            }
        }
    }

    //GET METHOD FOR DISPLAYING INCORRECT COLORS ON BOARD
    public void getBoardPositionIncorrect(int posi, int color) {
        //FOR FUTURE: call another method to add more spots depending on level

        getTemp1List(posi);
        getTemp2List(color);

        r3 = new Random();
        int incorrect = r3.nextInt(colors.size()) + 1;

        for (int k = 0; k < temp1.size(); k++) {
            if (temp1.contains(B_00) && temp2.contains(incorrect) && temp2.contains(color) == false) { //if this spot is avaliable, assign a color, if not move on
                getBoardPositionCorrect(B_00, incorrect);
            } else if (temp1.contains(B_01) && temp2.contains(incorrect) && temp2.contains(color) == false) {
                getBoardPositionCorrect(B_01, incorrect);
            } else if (temp1.contains(B_10) && temp2.contains(incorrect) && temp2.contains(color) == false) {
                getBoardPositionCorrect(B_10, incorrect);
            } else if (temp1.contains(B_11) && temp2.contains(incorrect) && temp2.contains(color) == false) {
                getBoardPositionCorrect(B_11, incorrect);
            }
        }

//        for (int k = 0; k < temp1.size(); k++) {
//            if (temp1.get(k) == B_00) { //if this spot is avaliable, assign a color, if not move on
//                getButton_00(r3.nextInt(temp2.size()) + 1);
//            } else if (temp1.get(k) == B_01) {
//                getButton_01(r3.nextInt(temp2.size()) + 1);
//            } else if (temp1.get(k) == B_10) {
//                getButton_10(r3.nextInt(temp2.size()) + 1);
//            } else {
//                getButton_11(r3.nextInt(temp2.size()) + 1);
//            }
//        }
    }//END OF getBPI GETTER

    //loop through temp1 list
    //checks to see if temp1 list contains said element
    //if contains said element, call getIncorrectColor()

    //    //generates incorrect color
//    //calls checkForColor() for confirmation
//    public void getIncorrectColor() {
//        r3 = new Random();
//        int color = r3.nextInt(colors.size()) + 1;
//
//        if (temp2.contains(color)) {//returns true if color exists in list
//
//        } else {
//            getIncorrectColor();
//        }
//
//    }

    //checks temp2 list to see if said color exists in list
    //if said color exists, call a button a
//    public void checkForColor(int checkColor) {
//        if (temp2.contains(checkColor)) {//returns true if color exists in list
//
//        } else {
//            getIncorrectColor();
//        }
//    }


    //BUTTONS
    public void getButton_00(int color) {
        switch (color) {
            case COLOR_RED:
                btn_00.setImageResource(R.drawable.red1);
                break;
            case COLOR_ORANGE:
                btn_00.setImageResource(R.drawable.orange1);
                break;
            case COLOR_YELLOW:
                btn_00.setImageResource(R.drawable.yellow1);
                break;
            case COLOR_GREEN:
                btn_00.setImageResource(R.drawable.green1);
                break;
            case COLOR_BLUE:
                btn_00.setImageResource(R.drawable.blue1);
                break;
            case COLOR_INDIGO:
                btn_00.setImageResource(R.drawable.indigo1);
                break;
            case COLOR_VIOLET:
                btn_00.setImageResource(R.drawable.violet1);
                break;
        }
    }//END OF BUTTON

    public void getButton_01(int color) {
        switch (color) {
            case COLOR_RED:
                btn_01.setImageResource(R.drawable.red1);
                break;
            case COLOR_ORANGE:
                btn_01.setImageResource(R.drawable.orange1);
                break;
            case COLOR_YELLOW:
                btn_01.setImageResource(R.drawable.yellow1);
                break;
            case COLOR_GREEN:
                btn_01.setImageResource(R.drawable.green1);
                break;
            case COLOR_BLUE:
                btn_01.setImageResource(R.drawable.blue1);
                break;
            case COLOR_INDIGO:
                btn_01.setImageResource(R.drawable.indigo1);
                break;
            case COLOR_VIOLET:
                btn_01.setImageResource(R.drawable.violet1);
                break;
        }
    }//END OF BUTTON

    public void getButton_10(int color) {
        switch (color) {
            case COLOR_RED:
                btn_10.setImageResource(R.drawable.red1);
                break;
            case COLOR_ORANGE:
                btn_10.setImageResource(R.drawable.orange1);
                break;
            case COLOR_YELLOW:
                btn_10.setImageResource(R.drawable.yellow1);
                break;
            case COLOR_GREEN:
                btn_10.setImageResource(R.drawable.green1);
                break;
            case COLOR_BLUE:
                btn_10.setImageResource(R.drawable.blue1);
                break;
            case COLOR_INDIGO:
                btn_10.setImageResource(R.drawable.indigo1);
                break;
            case COLOR_VIOLET:
                btn_10.setImageResource(R.drawable.violet1);
                break;
        }
    }//END OF BUTTON

    public void getButton_11(int color) {
        switch (color) {
            case COLOR_RED:
                btn_11.setImageResource(R.drawable.red1);
                break;
            case COLOR_ORANGE:
                btn_11.setImageResource(R.drawable.orange1);
                break;
            case COLOR_YELLOW:
                btn_11.setImageResource(R.drawable.yellow1);
                break;
            case COLOR_GREEN:
                btn_11.setImageResource(R.drawable.green1);
                break;
            case COLOR_BLUE:
                btn_11.setImageResource(R.drawable.blue1);
                break;
            case COLOR_INDIGO:
                btn_11.setImageResource(R.drawable.indigo1);
                break;
            case COLOR_VIOLET:
                btn_11.setImageResource(R.drawable.violet1);
                break;
        }

    }//END OF BUTTON

}//END OF CLASS


