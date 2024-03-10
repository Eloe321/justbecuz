package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                if (!Recall.getText().toString().equals("0")) {
                    Recall.append("0");
                }
                NumAv = true;
                updateResult(); // Call the method to update the result
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("1");

                NumAv = true;
                updateResult();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("2");

                NumAv = true;
                updateResult();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("3");

                NumAv = true;
                updateResult();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("4");

                NumAv = true;
                updateResult();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("5");

                NumAv = true;
                updateResult();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("6");

                NumAv = true;
                updateResult();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("8");

                NumAv = true;
                updateResult();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recall.append("9");

                NumAv = true;
                updateResult();
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '-' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/') {
                    Recall.setText(tmp.substring(0, ctr) + "+");
                } else if (NumAv) {
                    Recall.append("+");


                    NumAv = false;
                }


            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                int ctr = tmp.length() - 1;
                if (tmp.charAt(ctr) == '+' || tmp.charAt(ctr) == 'x' || tmp.charAt(ctr) == '/') {
                    Recall.setText(tmp.substring(0, ctr) + "-");
                } else if (NumAv) {
                    Recall.append("-");

                    NumAv = false;
                }
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                if (tmp.charAt(tmp.length() - 1) == '+' || tmp.charAt(tmp.length() - 1) == '-' || tmp.charAt(tmp.length() - 1) == '/') {
                    Recall.setText(tmp.substring(0, (tmp.length() - 1)) + "x");
                } else if (NumAv) {
                    Recall.append("x");

                    NumAv = false;
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(Recall.getText());
                if (tmp.charAt(tmp.length() - 1) == '+' || tmp.charAt(tmp.length() - 1) == '-' || tmp.charAt(tmp.length() - 1) == 'x') {
                    Recall.setText(tmp.substring(0, (tmp.length() - 1)) + "/");
                } else if (NumAv) {
                    Recall.append("/");
                    NumAv = false;
                }
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tmp = new StringBuilder(Recall.getText());
                if (NumAv && tmp.charAt(tmp.length() - 1) != '.') {
                    Recall.append(".");
                } else if (!NumAv) {
                    Recall.append("0.");
                    NumAv = true;
                }

            }
        });
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expression = Recall.getText().toString();
                try {
                    double result = ActualResult(expression);
                    String formattedResult = formatResult(result);
                    System.out.println(formattedResult);// Format the result
                    Recall.setText("");
                    Result.setText(formattedResult);

                } catch (Exception e) {
                    Result.setText("Error");
                }
            }
        });
    }


    private double evaluateExpression (String expression){
        // Split the expression into numbers and operators
        String[] tokens = expression.split("(?=[+\\-x/])|(?<=[+\\-x/])");

        // Initialize variables
        double result = Double.parseDouble(tokens[0]);
        char operator = ' ';

        // Iterate through the tokens to perform the calculations
        for (int i = 1; i < tokens.length; i++) {
            // If the token is an operator, store it for the next iteration
            if (tokens[i].matches("[+\\-x/]")) {
                operator = tokens[i].charAt(0);
            } else {
                // If the token is a number, perform the operation based on the stored operator
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
                        // Check for division by zero
                        if (operand == 0) {
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
            // If the result has decimal places, display it as it is
            DecimalFormat decimalFormat = new DecimalFormat("#.##########"); // Adjust the number of decimal places as needed
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

    private Double ActualResult (String expression){
        expression = expression.replaceAll("\\s+", "");

        // Split the expression into numbers, operators, and parentheses
        String[] tokens = expression.split("(?<=[-+x/()])|(?=[-+x/()])");

        // Use two stacks for numbers and operators
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Iterate through the tokens
        for (String token : tokens) {
            // Handle numbers
            if (token.matches("[0-9]+")) {
                numbers.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                operators.push(token.charAt(0));
            } else if (token.equals(")")) {
                // Evaluate expression within parentheses
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateOperator(numbers, operators);
                }
                operators.pop(); // Remove the '('
            } else { // Handle operators
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
                    throw new ArithmeticException("Division by zero");
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
        return (op1 != 'x' && op1 != '/') || (op2 != '+' && op2 != '-'); // op1 does not have precedence over op2
    }
}


