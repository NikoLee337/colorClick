package com.example.colorclick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.colorclick.R.drawable.abc_btn_switch_to_on_mtrl_00001;
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
    int matchColor = COLOR_RED;
    int otherColor = COLOR_RED;
    int currentLevel = 1;

    //comment here
//<<<<<<< HEAD
//    Handler handler;
//    Runnable runnable;
//    ProgressBar timer;
//    Random r1, r2, r3;
//    Dialog pause;
//    View v;
//
//    int currentTime = 5000;
//    int startTime = 5000;
//=======
//    Handler handler;
//    Runnable runnable;
//    ProgressBar timer;
    TextView timer;
    public long counter = 5;
    public long counterRemaining;
    CountDownTimer count;
    ImageButton pauseButton;
    Random r1, r2;
    Dialog pause;
    View v;

    boolean rightColor = false;

    public long currentTime = 5000;
    public long goDownTime = 1000;
    public long temp = 0;
//>>>>>>> origin/BackUpcolorClick

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //color button ids
        btn_00 = findViewById(R.id.button_00);
        btn_01 = findViewById(R.id.button_01);
        btn_10 = findViewById(R.id.button_10);
        btn_11 = findViewById(R.id.button_11);

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

        r2 = new Random();
        bPosition = r2.nextInt(4) + 1;

//        r3 = new Random();
//        otherColor = r1.nextInt(7) + 1;

        setMatchColor(matchColor);
        //generate board
        genMatchingColor(matchColor);
        boardPositionCorrect(bPosition, matchColor);
        //boardPositionIncorrect(bPosition, matchColor);

//        button_00(matchColor);
//        button_01(matchColor);
//        button_10(matchColor);
//        button_11(matchColor);

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

        pauseButton = (ImageButton) findViewById(R.id.button_pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // Opens pause menu dialog
                pauseMenu(v);

                // Cancels the CountDownTimer while the pause menu is open
                count.cancel();
            }
        });

        // Creates an area for the timer on the GameView
        timer = (TextView) findViewById(R.id.timerView);

        // The initial CountDownTimer is created upon playing the game
        count = new CountDownTimer(currentTime, goDownTime){
                public void onTick ( long millisUntilFinished){

                        // Sets the timer area with the counter
                        timer.setText(String.valueOf(counter));

                        // Counter is deducted by 1 every second
                        counter--;

                        // Keeps track of the initial counter
                        counterRemaining = counter;

                        // Keeps track of the initial time left
                        temp = millisUntilFinished;
            }
                // Calls GameOver page once timer runs out
                public void onFinish () {
                timer.setText("0");
                openGameOver();
            }
         // Starts the timer
        }.start();

        //find the timer/progressbar id
//        timer = findViewById(R.id.timer_progressbar);

        //set the initial timer to 5 seconds
//        timer.setMax(startTime);
//        timer.setProgress(startTime);

        //handles the timer/progressbar countdown and main loop
//        handler = new Handler();
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                currentTime = currentTime - 100;
//                timer.setProgress(currentTime);
//                if (currentTime > 0) {
//                    handler.postDelayed(runnable, 100);
//                } else if (currentTime == 0) {
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            openGameOver();
//                        }
//                    }, 100);
//                }
//            }
//        };
//        handler.postDelayed(runnable, 100);


        //playGame();
    }

    //display the random color for player to match
    private int setMatchColor(int match) {
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
                toBeMatch.setImageResource(R.drawable.indigo_footer);
                matchColor = COLOR_INDIGO;
                break;
            case COLOR_VIOLET:
                toBeMatch.setImageResource(R.drawable.violet_footer);
                matchColor = COLOR_VIOLET;
                break;
        }
        return match;
    }

    //randomizes the colors around the board
    private void genMatchingColor(int correct) {
        switch (correct) {
            case COLOR_RED:
                matchColor = COLOR_RED;
                break;
            case COLOR_ORANGE:
                matchColor = COLOR_ORANGE;
                break;
            case COLOR_YELLOW:
                matchColor = COLOR_YELLOW;
                break;
            case COLOR_GREEN:
                matchColor = COLOR_GREEN;
                break;
            case COLOR_BLUE:
                matchColor = COLOR_BLUE;
                break;
            case COLOR_INDIGO:
                matchColor = COLOR_INDIGO;
                break;
            case COLOR_VIOLET:
                matchColor = COLOR_VIOLET;
                break;
        }
    }

    //add int color
//    private void boardPositionIncorrect(int cp, int cc) {
//        List<Integer> temp1; //Temporary ArrayList to store button positions
//        List<Integer> position = new ArrayList<Integer>();
//        position.add(B_00); //value = 1
//        position.add(B_01); //value = 2
//        position.add(B_10); //value = 3
//        position.add(B_11); //value = 4
//
//        //Removing correct BUTTON POSITION from ArrayList
//        for (int i = 0; i < position.size(); i++) {
//            if (i == cp) {
//                position.remove(i);
//            }
//        }
//
//        temp1 = position; //ArrayList with button positions without correct button
//
//        List<Integer> temp2; //temporary ArrayList to store COLORS
//        List<Integer> colors = new ArrayList<Integer>(); //ArrayList for COLORS
//        colors.add(COLOR_RED);
//        colors.add(COLOR_ORANGE);
//        colors.add(COLOR_YELLOW);
//        colors.add(COLOR_GREEN);
//        colors.add(COLOR_BLUE);
//        colors.add(COLOR_INDIGO);
//        colors.add(COLOR_VIOLET);
//
//        //Removing correct COLOR from ArrayList
//        for (int i = 0; i < colors.size(); i++) {
//            if (i == cc) {
//                colors.remove(i);
//            }
//        }
//
//        temp2 = colors; //Storing ArrayList without correct into temporary ArrayList
//
//        List<Integer> temp3 = new ArrayList<Integer>(); //New temporary ArrayList storing x amount of color values
//        //Random for a COLOR to display that is not correct color
//        Random r = new Random();
//
//        //For each button leftover, random a COLOR and store into temp3 ArrayList
////        for(int j = 0; j < temp1.size(); j++ ){
////            temp3.add(r.nextInt(temp2.size())); //COLOR int value
////        }
//
//        for (int k = 0; k < temp1.size(); k++) {
//            if (k == B_00) {
//                button_00(r.nextInt(temp2.size()));
//            } else if (k == B_01) {
//                button_01(r.nextInt(temp2.size()));
//            } else if (k == B_10) {
//                button_10(r.nextInt(temp2.size()));
//            } else {
//                button_11(r.nextInt(temp2.size()));
//            }
//        }
//    }


//    private void genIncorrectColor(int cc){
//        List<Integer> temp2; //temporary ArrayList
//
//        List<Integer> colors = new ArrayList<Integer>(); //ArrayList for COLORS
//        colors.add(COLOR_RED);
//        colors.add(COLOR_ORANGE);
//        colors.add(COLOR_YELLOW);
//        colors.add(COLOR_GREEN);
//        colors.add(COLOR_BLUE);
//        colors.add(COLOR_INDIGO);
//        colors.add(COLOR_VIOLET);
//
//        //Removing correct COLOR from ArrayList
//        for(int i = 0; i < colors.size(); i++){
//            if(i == cc) {
//                colors.remove(i);
//            }
//        }
//
//        temp2 = colors; //Storing ArrayList without correct into temporary ArrayList
//
//        Random r = new Random();
//        for(int )
//        int ic = r.nextInt(temp.size());
//    }

    public void button_00(int color) {
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
    }

    public void button_01(int color) {
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
    }

    public void button_10(int color) {
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
    }

    public void button_11(int color) {
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
    }

    //
    private void boardPositionCorrect(int pos, int color) {

        switch (pos) {
            case B_00:
                button_00(color);
                bPosition = B_00;
                break;
            case B_01:
                button_01(color);
                bPosition = B_01;
                break;
            case B_10:
                button_10(color);
                bPosition = B_10;
                break;
            case B_11:
                button_11(color);
                bPosition = B_11;
        }
    }

    //randomizes the colors in an array
    public static int[] randomColorArray(int[] array) {
        Random rgen = new Random(); //generates random number

        for (int i = 0; i < array.length; i++) {
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
                count = new CountDownTimer(temp, goDownTime){
                    public void onTick (long millisUntilFinished){

                        // Sets the timer area with the counter
                        timer.setText(String.valueOf((counterRemaining)));

                        // Tracks the time left
                        temp = millisUntilFinished;

                        // Counter is deducted by 1 every second
                        counterRemaining--;
                    }
                    // Calls GameOver page once time runs out
                    public void onFinish () {
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
                count = new CountDownTimer(temp, goDownTime){
                    public void onTick (long millisUntilFinished){

                        // Sets the timer area with the counter
                        timer.setText(String.valueOf((counterRemaining)));

                        // Tracks the time left
                        temp = millisUntilFinished;

                        // Counter is deducted by 1 every second
                        counterRemaining--;
                    }
                    // Calls GameOver page once time runs out
                    public void onFinish () {
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