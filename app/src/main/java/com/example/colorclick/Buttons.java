package com.example.colorclick;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buttons extends GameView {

    public final static int B_00 = 1;
    public final static int B_01 = 2;
    public final static int B_10 = 3;
    public final static int B_11 = 4;
    int bPosition = B_00;

    public final static int COLOR_RED = 1;
    public final static int COLOR_ORANGE = 2;
    public final static int COLOR_YELLOW = 3;
    public final static int COLOR_GREEN = 4;
    public final static int COLOR_BLUE = 5;
    public final static int COLOR_INDIGO = 6;
    public final static int COLOR_VIOLET = 7;
    int matchColor = 1;

    int currentLevel = 1;


    //display the random color for player to match
    public int setMatchColor(int match) {
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

    //randomizes the colors around the board
    public void genMatchingColor(int correct) {

        int[] genBoardColor = {COLOR_RED, COLOR_ORANGE, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE, COLOR_INDIGO, COLOR_VIOLET};


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

    public void boardPositionIncorrect(int posi, int color) {
        List<Integer> temp;

        List<Integer> position = new ArrayList<Integer>();
        position.add(B_00); //value = 1
        position.add(B_01); //value = 2
        position.add(B_10); //value = 3
        position.add(B_11); //value = 4

        for (int i = 0; i < position.size(); i++) {
            if (i == posi) {
                position.remove(i);
            }
        }

        temp = position;

        List<Integer> colors = new ArrayList<Integer>();
        colors.add(COLOR_RED);
        colors.add(COLOR_ORANGE);
        colors.add(COLOR_YELLOW);
        colors.add(COLOR_GREEN);
        colors.add(COLOR_BLUE);
        colors.add(COLOR_INDIGO);
        colors.add(COLOR_VIOLET);

        for (int i = 0; i < colors.size(); i++) {
            if (i == color) {
                colors.remove(i);
            }
        }


        for (int k = 0; k < temp.size(); k++) {
            if (k == B_00) {
                button_00(color);
            } else if (k == B_01) {
                button_01(color);
            } else if (k == B_10) {
                button_10(color);
            } else {
                button_11(color);
            }
        }
    }

    public void boardPositionCorrect(int pos, int color) {
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

}