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

public class GamePlayOLD  {

//    GameView view = new GameView();
//
//    private final static int B_00 = 1;
//    private final static int B_01 = 2;
//    private final static int B_10 = 3;
//    private final static int B_11 = 4;
////    int corrButton = B_00; //correct button
////    ArrayList<Integer> positions = new ArrayList<>(Arrays.asList(B_00, B_01, B_10, B_11));
////    ArrayList<Integer> temp1; //TEMPORARY LIST TO STORE POSITIONS WITHOUT CORRECT POSITION(S)
////
//    private final static int COLOR_RED = 1;
//    private final static int COLOR_ORANGE = 2;
//    private final static int COLOR_YELLOW = 3;
//    private final static int COLOR_GREEN = 4;
//    private final static int COLOR_BLUE = 5;
//    private final static int COLOR_INDIGO = 6;
//    private final static int COLOR_VIOLET = 7;
////    int corrColor = 1;//correct color
////    ArrayList<Integer> colors = new ArrayList<>(Arrays.asList(COLOR_RED, COLOR_ORANGE, COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE, COLOR_INDIGO, COLOR_VIOLET));
////    ArrayList<Integer> temp2; //TEMPORARY LIST TO STORE COLORS OTHER THAN CORRECT COLOR(S)
//
//    int currentLevel = 1;
//


    //GENERATING COLORS AND POSITIONS
    //GENERATE THE CORRECT COLOR
//        r1 = new Random();
//        corrColor = r1.nextInt(colors.size()) + 1;
//
//        //GENERATE THE CORRECT BUTTON LOCATION(S)
//        r2 = new Random();
//        corrButton = r2.nextInt(positions.size()) + 1;
//
//        gpOLD.setMatchColor(corrColor); //SET CORRECT COLOR
//        gpOLD.getMatchColor(corrColor); //GET CORRECT COLOR
//        gpOLD.getBoardPositionCorrect(corrButton, corrColor); //GET CORRECT POSITION(S) AND DISPLAY CORRECT COLOR
//        gpOLD.getBoardPositionIncorrect(corrButton, corrColor); //GET INCORRECT POSITIONS(S) AND DISPLAY INCORRECT COLORS
    //******************************************************//

//        pause.startPause();
//
//    //SET METHOD FOR MATCHING COLOR (colored image at BOTTOM-RIGHT-CORNER of screen)
//    public int setMatchColor(int match) {
//        switch (match) {
//            case COLOR_RED:
//                view.matchTheColor.setImageResource(R.drawable.red_footer);
//                view.corrColor = view.COLOR_RED;
//                break;
//            case COLOR_ORANGE:
//                view.matchTheColor.setImageResource(R.drawable.orange_footer);
//                view.corrColor = view.COLOR_ORANGE;
//                break;
//            case COLOR_YELLOW:
//                view.matchTheColor.setImageResource(R.drawable.yellow_footer);
//                view.corrColor = view.COLOR_YELLOW;
//                break;
//            case COLOR_GREEN:
//                view.matchTheColor.setImageResource(R.drawable.green_footer);
//                view.corrColor = view.COLOR_GREEN;
//                break;
//            case COLOR_BLUE:
//                view.matchTheColor.setImageResource(R.drawable.blue_footer);
//                view.corrColor = view.COLOR_BLUE;
//                break;
//            case COLOR_INDIGO:
//                view.matchTheColor.setImageResource(R.drawable.indigo_footer);
//                view.corrColor = view.COLOR_INDIGO;
//                break;
//            case COLOR_VIOLET:
//                view.matchTheColor.setImageResource(R.drawable.violet_footer);
//                view.corrColor = view.COLOR_VIOLET;
//                break;
//        }
//        return match;
//    }//END OF MATCH COLOR SETTER
//
//    //GET METHOD FOR MATCHING COLOR
//    public void getMatchColor(int correct) {
//        switch (correct) {
//            case COLOR_RED:
//                view.corrColor = view.COLOR_RED;
//                break;
//            case COLOR_ORANGE:
//                view.corrColor = view.COLOR_ORANGE;
//                break;
//            case COLOR_YELLOW:
//                view.corrColor = view.COLOR_YELLOW;
//                break;
//            case COLOR_GREEN:
//                view.corrColor = view.COLOR_GREEN;
//                break;
//            case COLOR_BLUE:
//                view.corrColor = view.COLOR_BLUE;
//                break;
//            case COLOR_INDIGO:
//                view.corrColor = view.COLOR_INDIGO;
//                break;
//            case COLOR_VIOLET:
//                view.corrColor = view.COLOR_VIOLET;
//                break;
//
//        }
//
//    }//END OF MATCH COLOR GETTER
//
//    //GET METHOD FOR DISPLAYING CORRECT COLOR(S) ON BOARD
//    public void getBoardPositionCorrect(int pos, int color) {
//        switch (pos) {
//            case B_00:
//                getButton_00(color);
//                view.corrButton = view.B_00;
//                break;
//            case B_01:
//                getButton_01(color);
//                view.corrButton = view.B_01;
//                break;
//            case B_10:
//                getButton_10(color);
//                view.corrButton = view.B_10;
//                break;
//            case B_11:
//                getButton_11(color);
//                view.corrButton = view.B_11;
//        }
//    }//END OF getBPC GETTER
//
//    public void getTemp1List(int posi) {
//        for (int i = 0; i < view.positions.size(); i++) {
//            if (view.positions.contains(posi) && view.positions.get(i) == posi) {
//                view.positions.remove(i);
//                view.temp1 = new ArrayList<>(view.positions);
//                break;
//            }
//        }
//    }
//
//    public void getTemp2List(int color) {
//        for (int j = 0; j < view.colors.size(); j++) {
//            if (view.colors.contains(color) && view.colors.get(j) == color) { //color = 5 at index of 4
//                view.colors.remove(j);
//                view. temp2 = new ArrayList<>(view.colors);
//                break;
//            }
//        }
//    }
//
//    //GET METHOD FOR DISPLAYING INCORRECT COLORS ON BOARD
//    public void getBoardPositionIncorrect(int posi, int color) {
//        //FOR FUTURE: call another method to add more spots depending on level
//
//        getTemp1List(posi);
//        getTemp2List(color);
//
//        view.r3 = new Random();
//        int incorrect = view.r3.nextInt(view.colors.size()) + 1;
//        if (view.temp2.contains(color) != true) {
//            for (int k = 0; k < view.temp1.size(); k++) {
//                if (view.temp1.contains(view.B_00) && view.temp2.contains(incorrect) && view.temp2.contains(color) == false) { //if this spot is avaliable, assign a color, if not move on
//                    getBoardPositionCorrect(view.B_00, incorrect);
//                } else if (view.temp1.contains(view.B_01) && view.temp2.contains(incorrect) && view.temp2.contains(color) == false) {
//                    getBoardPositionCorrect(view.B_01, incorrect);
//                } else if (view.temp1.contains(view.B_10) && view.temp2.contains(incorrect) && view.temp2.contains(color) == false) {
//                    getBoardPositionCorrect(view.B_10, incorrect);
//                } else if (view.temp1.contains(view.B_11) && view.temp2.contains(incorrect) && view.temp2.contains(color) == false) {
//                    getBoardPositionCorrect(view.B_11, incorrect);
//                }
//            }
//        }
//
////        for (int k = 0; k < temp1.size(); k++) {
////            if (temp1.get(k) == B_00) { //if this spot is avaliable, assign a color, if not move on
////                getButton_00(r3.nextInt(temp2.size()) + 1);
////            } else if (temp1.get(k) == B_01) {
////                getButton_01(r3.nextInt(temp2.size()) + 1);
////            } else if (temp1.get(k) == B_10) {
////                getButton_10(r3.nextInt(temp2.size()) + 1);
////            } else {
////                getButton_11(r3.nextInt(temp2.size()) + 1);
////            }
////        }
//    }//END OF getBPI GETTER
//
//    //loop through temp1 list
//    //checks to see if temp1 list contains said element
//    //if contains said element, call getIncorrectColor()
//
//    //    //generates incorrect color
////    //calls checkForColor() for confirmation
////    public void getIncorrectColor() {
////        r3 = new Random();
////        int color = r3.nextInt(colors.size()) + 1;
////
////        if (temp2.contains(color)) {//returns true if color exists in list
////
////        } else {
////            getIncorrectColor();
////        }
////
////    }
//
//    //checks temp2 list to see if said color exists in list
//    //if said color exists, call a button a
////    public void checkForColor(int checkColor) {
////        if (temp2.contains(checkColor)) {//returns true if color exists in list
////
////        } else {
////            getIncorrectColor();
////        }
////    }
//
//
//    //BUTTONS
//    public void getButton_00(int color) {
//        switch (color) {
//            case COLOR_RED:
//                view.btn_00.setImageResource(R.drawable.red1);
//                break;
//            case COLOR_ORANGE:
//                view.btn_00.setImageResource(R.drawable.orange1);
//                break;
//            case COLOR_YELLOW:
//                view.btn_00.setImageResource(R.drawable.yellow1);
//                break;
//            case COLOR_GREEN:
//                view.btn_00.setImageResource(R.drawable.green1);
//                break;
//            case COLOR_BLUE:
//                view.btn_00.setImageResource(R.drawable.blue1);
//                break;
//            case COLOR_INDIGO:
//                view.btn_00.setImageResource(R.drawable.indigo1);
//                break;
//            case COLOR_VIOLET:
//                view.btn_00.setImageResource(R.drawable.violet1);
//                break;
//        }
//    }//END OF BUTTON
//
//    public void getButton_01(int color) {
//        switch (color) {
//            case COLOR_RED:
//                view.btn_01.setImageResource(R.drawable.red1);
//                break;
//            case COLOR_ORANGE:
//                view.btn_01.setImageResource(R.drawable.orange1);
//                break;
//            case COLOR_YELLOW:
//                view.btn_01.setImageResource(R.drawable.yellow1);
//                break;
//            case COLOR_GREEN:
//                view.btn_01.setImageResource(R.drawable.green1);
//                break;
//            case COLOR_BLUE:
//                view.btn_01.setImageResource(R.drawable.blue1);
//                break;
//            case COLOR_INDIGO:
//                view.btn_01.setImageResource(R.drawable.indigo1);
//                break;
//            case COLOR_VIOLET:
//                view.btn_01.setImageResource(R.drawable.violet1);
//                break;
//        }
//    }//END OF BUTTON
//
//    public void getButton_10(int color) {
//        switch (color) {
//            case COLOR_RED:
//                view.btn_10.setImageResource(R.drawable.red1);
//                break;
//            case COLOR_ORANGE:
//                view.btn_10.setImageResource(R.drawable.orange1);
//                break;
//            case COLOR_YELLOW:
//                view.btn_10.setImageResource(R.drawable.yellow1);
//                break;
//            case COLOR_GREEN:
//                view.btn_10.setImageResource(R.drawable.green1);
//                break;
//            case COLOR_BLUE:
//                view.btn_10.setImageResource(R.drawable.blue1);
//                break;
//            case COLOR_INDIGO:
//                view.btn_10.setImageResource(R.drawable.indigo1);
//                break;
//            case COLOR_VIOLET:
//                view.btn_10.setImageResource(R.drawable.violet1);
//                break;
//        }
//    }//END OF BUTTON
//
//    public void getButton_11(int color) {
//        switch (color) {
//            case COLOR_RED:
//                view.btn_11.setImageResource(R.drawable.red1);
//                break;
//            case COLOR_ORANGE:
//                view.btn_11.setImageResource(R.drawable.orange1);
//                break;
//            case COLOR_YELLOW:
//                view.btn_11.setImageResource(R.drawable.yellow1);
//                break;
//            case COLOR_GREEN:
//                view.btn_11.setImageResource(R.drawable.green1);
//                break;
//            case COLOR_BLUE:
//                view.btn_11.setImageResource(R.drawable.blue1);
//                break;
//            case COLOR_INDIGO:
//                view.btn_11.setImageResource(R.drawable.indigo1);
//                break;
//            case COLOR_VIOLET:
//                view.btn_11.setImageResource(R.drawable.violet1);
//                break;
//        }
//
//    }//END OF BUTTON
//
}
