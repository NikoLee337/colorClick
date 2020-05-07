package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    private Button button;
    private ImageButton playbutton;
    Dialog myDialog;
    MediaPlayer numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        numb = MediaPlayer.create(HomeScreen.this,R.raw.numb);
        numb.start();

        myDialog = new Dialog(this);
        //button = (Button) findViewById(R.id.button); this is the original instruction btn
        playbutton = (ImageButton) findViewById(R.id.playbutton);
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameView();
            }
        });
    }

    //pop up instructions view
    public void showInstructions (View v) {
        TextView closebutton;

        myDialog.setContentView(R.layout.instructionspopup);
        closebutton = (TextView) myDialog.findViewById(R.id.closebutton);

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        //myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    //opens the game window view
    public void openGameView() {
        numb.stop();
        Intent intent = new Intent(this, GameView21.class);
        startActivity(intent);
    }
}