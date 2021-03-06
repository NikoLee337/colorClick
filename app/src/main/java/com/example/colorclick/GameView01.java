package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GameView01 extends AppCompatActivity {
    //buttons
    private ImageButton btn_01, btn_02, btn_11, btn_12;
    ImageView matchTheColor;
    boolean rightColor = false;

    //Timer Variables
    TextView timer;
    public long counter = 3;
    public long counterRemaining;
    CountDownTimer count;
    ImageButton pauseButton;
    public long currentTime = 3000;
    public long goDownTime = 1000;
    public long temp = 0;
    Dialog pause;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game01);

//        MediaPlayer numb = MediaPlayer.create(GameView01.this,R.raw.numb);
//        numb.start();

        //CREATED ON GAME BOARD ON LOAD
        //DEFAULT IMAGE BUTTONS
        btn_01 = findViewById(R.id.button_01);
        btn_02 = findViewById(R.id.button_02);
        btn_11 = findViewById(R.id.button_11);
        btn_12 = findViewById(R.id.button_12);

        //DEFAULT IMAGE BUTTON REPRESENTING THE COLOR TO BE MATCHED
        matchTheColor = findViewById(R.id.imageView_color);
        matchTheColor.setClickable(false);
        //******************************************************//

        //method that moves to the next level
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                openGameView2();
            }
        });

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
                openGameOver(v);
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
        TextView menu;

        // Brings up the dialog when the pause button is clicked
        pause.setContentView(R.layout.pause_menu);

        // Main Menu button on the pause menu
        menu = (TextView) pause.findViewById(R.id.mainmenubutton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu(v);
            }
        });

        // Recreates a CountDownTimer with accurate time every time the 'X' button is clicked
        closebutton = (TextView) pause.findViewById(R.id.closebutton);
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
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
                        openGameOver(v);
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
            public void onClick(final View v) {
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
                        openGameOver(v);
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
    public void openGameOver(View v) {
        Intent intent = new Intent(this, GameOver.class);
        count.cancel();
        startActivity(intent);
    }//END OF GAMEOVER

    // RETURNS TO MAIN MENU FROM PAUSE MENU
    public void openMainMenu(View v) {
        Intent intent = new Intent(this, HomeScreen.class);
        count.cancel();
        startActivity(intent);
    }//END OF MAIN MENU

    public void openGameView2() {
        Intent intent = new Intent(this, GameView02.class);
        startActivity(intent);
    }
}//END OF CLASS


