package com.example.colorclick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class GameOver extends AppCompatActivity {

    Button playagain;
    Button mainmenu;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        playagain = findViewById(R.id.playagainbutton);
        mainmenu = findViewById(R.id.mainmenubutton);
        exit = (Button) findViewById(R.id.exitbutton);

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameView();
            }
        });

        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                moveTaskToBack(true);
            }
        });

    }

    public void openGameView() {
        Intent intent = new Intent(this, GameView.class);
        startActivity(intent);
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
