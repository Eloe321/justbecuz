package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        Button btn = findViewById(R.id.btnbtn);
        if (item.getItemId() == R.id.txtSize)
        {
            Toast.makeText( this,  "Changing Text Size!", Toast.LENGTH_SHORT).show();
            Random r = new Random();
            float n = r.nextInt(90)+10;
            btn.setTextSize(n);

        } else if (item.getItemId() == R.id.ColorChange) {
            Toast.makeText( this, "Changing The Color", Toast.LENGTH_SHORT).show();
            Random r= new Random();
            int red = r.nextInt(256);
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            btn.setBackgroundColor(Color.rgb(red, green, blue));
        }else if (item.getItemId() == R.id.NewText) {
            Toast.makeText( this, "Changing The Color", Toast.LENGTH_SHORT).show();
            String[] randomTexts = {"Click Me!", "Surprise Text", "Wow!", "Crazy!", "Hi Sir"};
            Random r = new Random();
            int ind = r.nextInt(randomTexts.length);
            btn.setText(randomTexts[ind]);
        }else if (item.getItemId() == R.id.weird) {
            Toast.makeText( this, "Changing The Color", Toast.LENGTH_SHORT).show();
            btn.setBackgroundResource(R.drawable.weirdbutton);
        }else if (item.getItemId() == R.id.Rot) {
            Toast.makeText( this, "Changing The Color", Toast.LENGTH_SHORT).show();

        }
        else if (item.getItemId() ==R.id.Reset) {
            Toast.makeText( this, "Button Reseted", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() ==R.id.Exit) {
            finish();
        }

        return true;
    }
}