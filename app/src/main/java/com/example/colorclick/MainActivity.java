package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageButton playbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        playbutton = (ImageButton) findViewById(R.id.playbutton);

        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openInstructions();
           }
        });

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameView();
            }
        });

    }

    //opens the game window view
    public void openGameView() {
        Intent intent = new Intent(this, GameView.class);
        startActivity(intent);
    }
    //opens the instructions view window
    public void openInstructions() {
        Intent intent = new Intent (this, InstructionWindow.class);
        startActivity(intent);
    }
}