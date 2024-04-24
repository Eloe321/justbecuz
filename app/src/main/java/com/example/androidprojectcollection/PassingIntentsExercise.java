package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class PassingIntentsExercise extends AppCompatActivity {
    Spinner spinYear, spinProgram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        Toast.makeText(getApplicationContext(), "Welcome to Passing Intents!", Toast.LENGTH_LONG).show();
        spinYear = findViewById(R.id.spinner1);
        String[] year = new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year"};



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, year);
        spinYear.setAdapter(adapter);

        spinProgram = findViewById(R.id.spinner2);
        String[] prog = new String[]{"BSCS", "BSIT", "BSBA", "BSCE", "BSCPE", "BSFA"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, prog);
        spinProgram.setAdapter(adapter2);



        startProgram();
    }

    void startProgram(){
        Button clear = findViewById(R.id.Clear);


        EditText[] edi = new EditText[11];

        for(int i =0; i<11; i++) {
            String oke = "edi" + Integer.toString(i+1);

            int resID = getResources().getIdentifier(oke, "id", getPackageName());
            edi[i] = (EditText) findViewById(resID);
            if(i < 6) {
                int finalI = i;
                edi[i].setOnClickListener(v-> {

                    if (edi[finalI].getText().toString().equals("First Name") || edi[finalI].getText().toString().equals("Last Name"))
                        edi[finalI].setText("");

                });
            }
        }

        RadioButton rMale = findViewById(R.id.rMale);
        RadioButton rFem = findViewById(R.id.rFemale);
        RadioButton roth = findViewById(R.id.rOthers);



        Button sub = (Button) findViewById(R.id.Submit);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName = edi[0].getText().toString();
                String lName = edi[1].getText().toString();
                String MFName = edi[2].getText().toString();
                String MLName = edi[3].getText().toString();
                String FrFName = edi[4].getText().toString();
                String FrLName = edi[5].getText().toString();
                String eAddress = edi[6].getText().toString();
                String bDate = edi[7].getText().toString();
                String pNumber = edi[8].getText().toString();
                String pEmerNumber = edi[9].getText().toString();
                String emailAdd = edi[10].getText().toString();
                String year = spinYear.getSelectedItem().toString();
                String prog = spinProgram.getSelectedItem().toString();



                String gender;
                if(rMale.isChecked())
                    gender = "Male";
                else if (rFem.isChecked())
                    gender = "Female";
                else if (roth.isChecked())
                    gender = "Others";
                else
                    gender = "Unknown";

                Intent intent = new Intent(  PassingIntentsExercise. this, PassingIntentsExercise2.class);
                intent.putExtra( "key1", fName);
                intent.putExtra( "key2", lName);
                intent.putExtra( "key3", prog);
                intent.putExtra( "key4", year);
                intent.putExtra( "key5", gender);
                intent.putExtra( "key6",bDate);
                intent.putExtra( "key7", pNumber);
                intent.putExtra( "key8", pEmerNumber);
                intent.putExtra( "key9", emailAdd);
                intent.putExtra( "key10", MFName+" "+MLName);
                intent.putExtra( "key11", FrFName+" "+FrLName);
                intent.putExtra( "key12", eAddress);

                startActivity(intent);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i<11; i++){
                    if(i < 6){
                        if(i%2 == 0)
                            edi[i].setText("First Name");
                        else
                            edi[i].setText("Last Name");

                    }
                    edi[i].setText("");
                }

                rMale.setChecked(false);
                rFem.setChecked(false);
                roth.setChecked(false);
                spinProgram.setSelected(false);
                spinYear.setSelected(false);
            }

        });
    }
}