package com.example.androidprojectcollection;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        Button ret = (Button) findViewById(R.id.ret);
        TextView[] tx = new TextView[12];
        for(int i =0; i<12; i++) {
            String oke = "txt" + Integer.toString(i+1);
            int resID = getResources().getIdentifier(oke, "id", getPackageName());
            tx[i] = (TextView) findViewById(resID);

        }

        Intent intent = getIntent();


        for(int i =0; i<12; i++) {
            String oke = "key" + Integer.toString(i+1);
            tx[i].setText(intent.getStringExtra(oke));
        }



        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}