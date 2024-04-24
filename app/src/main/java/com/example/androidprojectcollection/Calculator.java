package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Stack;

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
    Boolean NumAv = false;
    Boolean checkDec = true;

    String checkLast = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toast.makeText(getApplicationContext(), "Welcome To The Calculator", Toast.LENGTH_LONG).show();
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
                StringBuilder tmp = new StringBuilder(Recall.getText());
                int ctr = tmp.length() - 1;

                if (tmp.length() != 0) {
                    if ((tmp.charAt(ctr) == '+' || tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/') ) {
                        Recall.append("0");
                        if(checkLast.isEmpty())
                            checkLast = "0";
                        NumAv = true;
                        updateResult();
                    } else if(checkLast.equals("1") || !checkDec) {
                        Recall.append("0");
                        if(checkLast.isEmpty())
                            checkLast = "0";
                        NumAv = true;
                        updateResult();
                    }
                }else{
                    Recall.append("0");
                    checkLast = "0";
                    NumAv = true;
                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("1");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "1");
                    checkLast = "1";
                }else
                    Recall.append("1");
                NumAv = true;
                updateResult();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("2");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "2");
                    checkLast = "1";
                }else
                    Recall.append("2");
                NumAv = true;
                updateResult();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("3");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "3");
                    checkLast = "1";
                }else
                    Recall.append("3");
                NumAv = true;
                updateResult();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("4");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "4");
                    checkLast = "1";
                }else
                    Recall.append("4");
                NumAv = true;
                updateResult();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("5");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "5");
                    checkLast = "1";
                }else
                    Recall.append("5");
                NumAv = true;
                updateResult();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("6");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "6");
                    checkLast = "1";
                }else
                    Recall.append("6");
                NumAv = true;
                updateResult();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("7");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "7");
                    checkLast = "1";
                }else
                    Recall.append("7");

                NumAv = true;
                updateResult();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("8");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "8");
                    checkLast = "1";
                }else
                    Recall.append("8");
                NumAv = true;
                updateResult();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLast.isEmpty()) {
                    checkLast = "1";
                    Recall.append("9");
                }
                else if(checkLast.equals("0") && checkDec) {
                    StringBuilder tmp = new StringBuilder(Recall.getText());
                    Recall.setText(tmp.substring(0, tmp.length()-1) + "9");
                    checkLast = "1";
                }else
                    Recall.append("9");

                NumAv = true;
                updateResult();
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Recall.getText().equals("")){
                    return;
                } StringBuilder tmp = new StringBuilder();

                tmp.append(Recall.getText());

                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/' || tmp.charAt(ctr) == '.') {
                    Recall.setText(tmp.substring(0, ctr) + "+");
                    NumAv = false;
                } else if (NumAv) {
                    Recall.append("+");
                    checkLast = "";
                    NumAv = false;
                    checkDec= true;
                }


            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Recall.getText().equals("")){
                    return;
                }
                StringBuilder tmp = new StringBuilder();

                tmp.append(Recall.getText());

                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '+' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/'|| tmp.charAt(ctr) == '.') {
                    Recall.setText(tmp.substring(0, ctr) + "-");
                    NumAv = false;
                } else if (NumAv) {
                    Recall.append("-");
                    checkLast = "";
                    checkDec= true;
                    NumAv = false;
                }
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Recall.getText().equals("")){
                    return;
                }
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());

                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '+' || tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == '/'|| tmp.charAt(ctr) == '.') {
                    Recall.setText(tmp.substring(0, (tmp.length() - 1)) + "x");
                    NumAv = false;
                } else if (NumAv) {
                    Recall.append("x");
                    checkLast = "";
                    checkDec= true;
                    NumAv = false;
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Recall.getText().equals("")){
                    return;
                }
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '+' || tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '.') {
                    Recall.setText(tmp.substring(0, (tmp.length() - 1)) + "/");
                    NumAv = false;
                } else if (NumAv) {
                    Recall.append("/");
                    checkLast = "";
                    NumAv = false;
                    checkDec= true;
                }
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder(Recall.getText());
                if(tmp.charAt(tmp.length() - 1) == '.'){
                    Recall.setText(tmp.substring(0,tmp.length()-1));
                    checkDec = true;
                }
                else if (NumAv && checkDec && tmp.charAt(tmp.length() - 1) != '.' && (tmp.charAt(tmp.length() - 1) != '+' && tmp.charAt(tmp.length() - 1) != '-' && tmp.charAt(tmp.length() - 1) != 'x' && tmp.charAt(tmp.length() - 1) != '/') ){
                    Recall.append(".");
                    checkDec = false;
                    NumAv = true;
                } else if (checkDec && !NumAv) {
                    Recall.append("0.");
                    NumAv = true;
                    checkDec = false;
                }

            }
        });
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder(Recall.getText());
                if (!tmp.toString().isEmpty() && tmp.charAt(tmp.length() - 1) != '+' && tmp.charAt(tmp.length() - 1) != '-' && tmp.charAt(tmp.length() - 1) != 'x' && tmp.charAt(tmp.length() - 1) != '/') {
                    String expression = Recall.getText().toString();
                    try {
                        double result = ActualResult(expression);
                        String formattedResult = formatResult(result);
                        Recall.setText("");
                        Result.setText(formattedResult);

                        checkLast = "";
                        checkDec = true;
                    } catch (Exception e) {
                        Result.setText("Invalid");
                        checkLast = "";
                        checkDec = true;
                    }
                }
            }
        });


    }


    private double evaluateExpression (String expression){

        String[] tokens = expression.split("(?=[+\\-x/])|(?<=[+\\-x/])");


        double result = Double.parseDouble(tokens[0]);
        char operator = ' ';


        for (int i = 1; i < tokens.length; i++) {

            if (tokens[i].matches("[+\\-x/]")) {
                operator = tokens[i].charAt(0);
            } else {

                double operand = Double.parseDouble(tokens[i]);
                switch (operator) {
                    case '+':
                        result += operand;
                        break;
                    case '-':
                        result -= operand;
                        break;
                    case 'x':
                        result *= operand;
                        break;
                    case '/':

                        if (operand == 0) {
                            Result.setText("");

                            throw new ArithmeticException("Division by zero");
                        }
                        result /= operand;
                        break;
                }
            }
        }
        return result;
    }
    private String formatResult ( double result){
        // Check if the result has decimal places
        if (result == (long) result) {
            // If the result is an integer, remove the decimal part
            return String.format("%d", (long) result);
        } else {

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            return decimalFormat.format(result);
        }
    }
    private void updateResult () {
        String expression = Recall.getText().toString();
        if (expression.contains("+") || expression.contains("-") || expression.contains("x") || expression.contains("/")) {
            try {
                double result = evaluateExpression(expression);
                String formattedResult = formatResult(result);
                Result.setText(formattedResult);
            } catch (Exception e) {
                Result.setText("");
            }
        } else {
            Result.setText("");
        }
    }

    private Double ActualResult(String expression) {
        expression = expression.replaceAll("\\s+", "");

        String[] tokens = expression.split("(?<=[-+x/()])|(?=[-+x/()])");

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                numbers.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                operators.push(token.charAt(0));
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateOperator(numbers, operators);
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && Precedence(token.charAt(0), operators.peek())) {
                    evaluateOperator(numbers, operators);
                }
                operators.push(token.charAt(0));
            }
        }

        while (!operators.isEmpty()) {
            evaluateOperator(numbers, operators);
        }
        return numbers.pop();
    }

    private void evaluateOperator (Stack < Double > numbers, Stack < Character > operators){
        char operator = operators.pop();
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case 'x':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    Recall.setText("");
                    Result.setText("");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        numbers.push(result);
    }
    private boolean Precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != 'x' && op1 != '/') || (op2 != '+' && op2 != '-');
    }
}


