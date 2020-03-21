package com.example.colorclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class InstructionWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_window);

        //change color of the background
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);
        
    }
}