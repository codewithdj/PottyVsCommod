package com.example.deepak.tictactoegame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void buClick(View view) {
        ImageButton buSelected = (ImageButton) view;
        int cellId= 0;
        switch (buSelected.getId()){
            case R.id.bu1:
                cellId = 1;
                break;

            case R.id.bu2:
                cellId = 2;
                break;

            case R.id.bu3:
                cellId = 3;
                break;

            case R.id.bu4:
                cellId = 4;
                break;

            case R.id.bu5:
                cellId = 5;
                break;

            case R.id.bu6:
                cellId = 6;
                break;

            case R.id.bu7:
                cellId = 7;
                break;

            case R.id.bu8:
                cellId = 8;
                break;

            case R.id.bu9:
                cellId = 9;
                break;
        }

        playGame(cellId, buSelected);

    }

    int activePlayer = 1;
    boolean notWinner = false;
    ArrayList<Integer> player1 = new ArrayList<Integer>(); // hold player 1 data
    ArrayList<Integer> player2 = new ArrayList<Integer>(); // hold player 2 data

    void playGame(int cellId, ImageButton buSelected){
       // buSelected.setBackgroundColor(Color.RED);
     //   Log.d("Player", String.valueOf(cellId));
    if(!notWinner) {
        if (activePlayer == 1) {
            // buSelected.setText("X");
            // buSelected.setBackgroundColor(Color.GREEN);
            buSelected.setImageResource(R.drawable.poo);

            player1.add(cellId);
            activePlayer = 2;

            //   autoPlay();
        } else if (activePlayer == 2) {
            //   buSelected.setText("0");
            //  buSelected.setBackgroundColor(Color.BLUE);
            buSelected.setImageResource(R.drawable.commod);
            player2.add(cellId);
            activePlayer = 1;
        }
    }

        buSelected.setEnabled(false);
        checkWinner();
    }

    void checkWinner(){
        int winner = -1;

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1;

        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2;
        }
        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1;
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2;
        }
        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2;
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2;
        }

        // col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1;
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2;
        }

        // col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2;
        }

        // diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2;
        }

        // diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2;
        }

        if(winner!=-1){
            // we have winner

            if(winner == 1){
                Toast.makeText(this, "Potty is Winner", Toast.LENGTH_LONG).show();
                notWinner= true;

            }

            else if(winner == 2){
                Toast.makeText(this, "Commod is Winner", Toast.LENGTH_LONG).show();
                notWinner = true;
            }
        }
    }

    void autoPlay(){
        ArrayList<Integer> emptyCells = new ArrayList<Integer>();

        for(int cellId=1;cellId<10;cellId++){
            if(!(player1.contains(cellId)) || player2.contains(cellId)){
                emptyCells.add(cellId);
            }
        }

        Random r = new Random();
        int randIndex = r.nextInt(emptyCells.size()-0)+0;
        int cellId= emptyCells.get(randIndex);

        ImageButton buSelected;

        switch (cellId){
            case 1:
                buSelected = (ImageButton) findViewById(R.id.bu1);
                break;

            case 2:
                buSelected = (ImageButton) findViewById(R.id.bu2);
                break;

            case 3:
                buSelected = (ImageButton) findViewById(R.id.bu3);
                break;

            case 4:
                buSelected = (ImageButton) findViewById(R.id.bu4);
                break;

            case 5:
                buSelected = (ImageButton) findViewById(R.id.bu5);
                break;

            case 6:
                buSelected = (ImageButton) findViewById(R.id.bu6);
                break;

            case 7:
                buSelected = (ImageButton) findViewById(R.id.bu7);
                break;

            case 8:
                buSelected = (ImageButton) findViewById(R.id.bu8);
                break;

            case 9:
                buSelected = (ImageButton) findViewById(R.id.bu9);
                break;
            default:buSelected = (ImageButton) findViewById(R.id.bu1);
        }

        playGame(cellId, buSelected);


    }

    public void imgButtonClick(View view) {
        ImageButton imageButton = (ImageButton) view;
        imageButton.setImageResource(R.drawable.pooo);

    }
}
