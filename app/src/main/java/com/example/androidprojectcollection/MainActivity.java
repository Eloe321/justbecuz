package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bu1;
    Button bu2;
    Button bu3;
    Button bu4;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bu1 = (Button) findViewById(R.id.change);
        bu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, Layout_exercise.class);
                startActivity(intent);
            }
        });

        bu2 = (Button) findViewById(R.id.butbut);
        bu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, button_exercise.class);
                startActivity(intent);
            }
        });
        bu3 = (Button) findViewById(R.id.Byebye);
        bu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bu4 = (Button) findViewById(R.id.Calculator);
        bu4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
    }
}