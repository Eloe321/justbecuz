package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

public class button_exercise extends AppCompatActivity {

    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);
        Toast.makeText(getApplicationContext(), "Welcome To The Button Exercise", Toast.LENGTH_LONG).show();
        btn4 = (Button) findViewById(R.id.btnReturn);
        btn4.setOnClickListener(v -> {
            Intent back = new Intent(button_exercise.this, yeh.class);
            startActivity(back);
        });

        btn2 = (Button) findViewById(R.id.btnHide);
        btn2.setOnClickListener(v -> btn2.setVisibility(View.GONE));
        btn3 = (Button) findViewById(R.id.btnToast);
        btn3.setOnClickListener(v -> Toast.makeText(button_exercise.this, "This is my Toast message!",
                Toast.LENGTH_LONG).show());

        btn5 = (Button) findViewById(R.id.btnRdmBG);
        btn5.setOnClickListener(v -> {
            Random rnd = new Random();
            ConstraintLayout yow = findViewById(R.id.Everythin);
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            yow.setBackgroundColor(color);
        });
        btn6 = (Button) findViewById(R.id.btnRandom);
        btn6.setOnClickListener(v -> {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            btn6.setBackgroundColor(color);
        });

    }
}