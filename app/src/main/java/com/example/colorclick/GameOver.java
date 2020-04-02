package com.example.colorclick;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class GameOver extends AppCompatActivity {

    Button playagain;
    Button mainmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        playagain = findViewById(R.id.playagainbutton);
        mainmenu = findViewById(R.id.mainmenubutton);

    }

}
