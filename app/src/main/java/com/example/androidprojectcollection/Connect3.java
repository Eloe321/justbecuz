package com.example.androidprojectcollection;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Connect3 extends AppCompatActivity {

    ImageButton[][] buttons;
    int[][] chekz;
    Boolean PlayerTurn = false;
    Button reset;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);
        Toast.makeText(getApplicationContext(), "Welcome to Connect 3!", Toast.LENGTH_LONG).show();
        StartProgram();
    }
     void StartProgram(){
        TextView player = (TextView) findViewById(R.id.PlayingPlayer);
        player.setBackgroundColor(Color.parseColor("#8c271e"));
        buttons = new ImageButton[5][5];
        chekz = new int[5][5];
        int ctr = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button" + Integer.toString(ctr++);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = ((ImageButton) findViewById(resID));
                chekz[i][j] = 0;
                buttons[i][j].setBackgroundColor(Color.BLACK);
                if(i != 0){
                    buttons[i][j].setEnabled(false);
                }

            }

        }


        for(int k = 0; k<5;k++){
            int K = k;
            buttons[0][K].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 4; i>=0;i--){
                        if(chekz[i][K] == 0){
                            if(i == 0) {
                                buttons[0][K].setEnabled(false);
                            }
                            if(PlayerTurn) {
                                buttons[i][K].setImageResource(R.drawable.yellowcircle);
                                chekz[i][K] = 1;
                            }
                            else{
                                buttons[i][K].setImageResource(R.drawable.redcircle);
                                chekz[i][K] = 2;
                            }
                            if(ConnectTHREE(i, K))
                                EndGame(player, buttons);
                            else
                                SwitchPlayer(player);
                            System.out.println("The Array: ");
                            for(int j = 0; j<5; j++){
                                for(int l = 0; l<5; l++){
                                    System.out.print(chekz[j][l]+" ");
                                }
                                System.out.println();
                            }
                            break;
                        }

                    }


                }
            });
        }



    }

    void SwitchPlayer(TextView p){
        if(PlayerTurn){
            PlayerTurn = false;
            p.setBackgroundColor(Color.parseColor("#8c271e"));
            p.setText("Player 1");

        }
        else{
            PlayerTurn = true;
            p.setBackgroundColor(Color.parseColor("#e8e417"));
            p.setText("Player 2");

        }
    }

    boolean ConnectTHREE(int row, int col) {
        int value = chekz[row][col];

        for (int[] offset : new int[][]{{0, 1}, {1, 0}, {1, 1}, {1, -1}}) {
            int count = 1;
            for (int i = 1; i <= 2; i++) {
                int newRow = row + i * offset[0];
                int newCol = col + i * offset[1];
                if (newRow >= 0 && newRow < 5 && newCol >= 0 && newCol < 5 && chekz[newRow][newCol] == value) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = -1; i >= -2; i--) {
                int checkerRow = row + i * offset[0];
                int checkerCol = col + i * offset[1];
                if (checkerRow >= 0 && checkerRow < 5 && checkerCol >= 0 && checkerCol < 5 && chekz[checkerRow][checkerCol] == value) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= 3) {
                System.out.println("win");
                return true;
            }
        }

        return false;
    }

    void EndGame(TextView p, ImageButton[][] b){

        String tmp = (String) p.getText();
        p.setText("GAME OVER WE HAVE A WINNER!");
        for(int i = 0; i<5; i++){
            b[0][i].setEnabled(false);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(Connect3.this);
        builder.setMessage("GAME OVER! " + tmp + " wins!")
                .setCancelable(false)
                .setPositiveButton("Reset Game", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ResetGame();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();



    }

    void ResetGame(){
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 0) {
                    buttons[i][j].setEnabled(true);
                }
                buttons[i][j].setImageResource(R.drawable.bettercircle);
                chekz[i][j] = 0;

            }
        }


        PlayerTurn = false;


        TextView player = findViewById(R.id.PlayingPlayer);
        player.setText("Player 1");
        player.setBackgroundColor(Color.parseColor("#8c271e"));


    }
}