package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isNewOp = true;
    boolean dotPresent = false;
    boolean np = false;

    String oldNumber, newNumber;
    String op;

    TextView io_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        io_screen = findViewById(R.id.io_screen);
        io_screen.setText("0");
    }

    @SuppressLint("NonConstantResourceId")
    public void numberEvent(View view) {
        if (isNewOp) {
            io_screen.setText("");
        }
        isNewOp = false;

        String number = io_screen.getText().toString();
        switch (view.getId()) {
            case R.id.btn0:
                if (number.equals("0") || number.isEmpty()) {
                    isNewOp = true;
                }
                number += "0";
                break;
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btnNP:
                if (!np) {
                    np = true;
                    number = "-" + number;
                } else {
                    np = false;
                    number = number.substring(1);
                }
                break;
        }
        io_screen.setText(number);
    }

    public void clearAll(View view) {
        io_screen.setText("0");
        isNewOp = true;
        dotPresent = false;
        np = false;
    }

    @SuppressLint("SetTextI18n")
    public void dotEvent(View view) {
        if (!dotPresent) {
            io_screen.setText(io_screen.getText() + ".");
            dotPresent = true;
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = io_screen.getText().toString();
        switch (view.getId()) {
            case R.id.btnDiv:
                op = "/";
                break;
            case R.id.btnMul:
                op = "&#xd7;";
                break;
            case R.id.btnSub:
                op = "-";
                break;
            case R.id.btnAdd:
                op = "+";
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void percentEvent(View view) {
        try {
            double number = Double.parseDouble(io_screen.getText().toString()) / 100;
            io_screen.setText(number + "");
            isNewOp = true;
        } catch (Exception e) {
//            Log.e("MyCalculator", "exception", e);
            io_screen.setText("ERROR");
        }
    }

    @SuppressLint("SetTextI18n")
    public void equalEvent(View view) {
        newNumber = io_screen.getText().toString();
        double result = 0.0;
        switch (op) {
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "&#xd7;":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
        }
        io_screen.setText(result + "");
    }
}