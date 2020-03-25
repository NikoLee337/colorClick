package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    Animation fromtheside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //sets the logo into a variable name, set the animation into a variable name
        logo = (ImageView) findViewById(R.id.logo);
        fromtheside = AnimationUtils.loadAnimation(this,R.anim.fromtheside);

        //logo comes from the side
        logo.setAnimation(fromtheside);

        //this is the loading screen
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}