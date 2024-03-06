package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPlus;
    Button btnMinus;
    Button btnMult;
    Button btnDiv;
    Button btnDec;
    Button btnEq;
    TextView Recall;
    TextView Result;
    Boolean Decfind = false;
    Boolean NumAv = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Recall = findViewById(R.id.Rev);
        Result = findViewById(R.id.Result);
        btn0 = findViewById(R.id.num0);
        btn1 = findViewById(R.id.num1);
        btn2 = findViewById(R.id.num2);
        btn3 = findViewById(R.id.num3);
        btn4 = findViewById(R.id.num4);
        btn5 = findViewById(R.id.num5);
        btn6 = findViewById(R.id.num6);
        btn7 = findViewById(R.id.num7);
        btn8 = findViewById(R.id.num8);
        btn9 = findViewById(R.id.num9);
        btnPlus = findViewById(R.id.opPlus);
        btnMinus = findViewById(R.id.opMinus);
        btnMult = findViewById(R.id.opMult);
        btnDiv = findViewById(R.id.opDiv);
        btnDec = findViewById(R.id.decimal);
        btnEq = findViewById(R.id.Equals);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Recall.getText() != "0")
                    Recall.append("0");

                NumAv = true;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("1");

                NumAv = true;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("2");

                NumAv = true;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("3");

                NumAv = true;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("4");

                NumAv = true;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("5");

                NumAv = true;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("6");

                NumAv = true;
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("8");

                NumAv = true;
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("9");

                NumAv = true;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                int ctr = tmp.length()-1;
                if(tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/') {
                    Recall.setText(tmp.substring(0, ctr)+"+");
                }
                else if(NumAv) {
                    Recall.append("+");

                    Decfind = false;
                    NumAv = false;
                }

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                if(tmp.charAt(tmp.length()-1) == '+' || tmp.charAt(tmp.length()-1) == 'x' || tmp.charAt(tmp.length()-1) == '/') {
                    Recall.setText(tmp.substring(0, (tmp.length()-1))+"-");
                }

                else if(NumAv) {
                    Recall.append(Result.getText() + "-");
                    Decfind = false;
                    NumAv = false;
                }
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                if(tmp.charAt(tmp.length()-1) == '+' || tmp.charAt(tmp.length()-1) == '-' || tmp.charAt(tmp.length()-1) == '/') {
                    Recall.setText(tmp.substring(0, (tmp.length()-1))+"x");
                }

                else if(NumAv) {
                    Recall.append(Result.getText() + "x");

                    Decfind = false;
                    NumAv = false;
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                if(tmp.charAt(tmp.length()-1) == '+' || tmp.charAt(tmp.length()-1) == '-' || tmp.charAt(tmp.length()-1) == 'x') {
                    Recall.setText(tmp.substring(0, (tmp.length()-1))+"/");
                }
                else if(NumAv) {
                    Recall.append(Result.getText() + "/");
                    Result.setText("");
                    Decfind = false;
                    NumAv = false;
                }
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Decfind && NumAv) {
                    Result.append(".");
                    Decfind = true;
                }
                if (!Decfind) {
                    Result.append("0.");
                    Decfind = true;
                    NumAv = true;
                }

            }
        });
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result.append("0");
            }
        });





    }
}