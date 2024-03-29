package com.example.day1app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button clear;
    private Button add;
    private Button sub;
    private Button multi;
    private Button div;
    private Button equal;
    private TextView info;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupOIViews();

        zero.setOnClickListener(view -> info.setText(info.getText().toString() + "0"));

        one.setOnClickListener(view -> info.setText(info.getText().toString() + "1"));

        two.setOnClickListener(view -> info.setText(info.getText().toString() + "2"));

        three.setOnClickListener(view -> info.setText(info.getText().toString() + "3"));

        four.setOnClickListener(view -> info.setText(info.getText().toString() + "4"));

        five.setOnClickListener(view -> info.setText(info.getText().toString() + "5"));

        six.setOnClickListener(view -> info.setText(info.getText().toString() + "6"));

        seven.setOnClickListener(view -> info.setText(info.getText().toString() + "7"));

        eight.setOnClickListener(view -> info.setText(info.getText().toString() + "8"));

        nine.setOnClickListener(view -> info.setText(info.getText().toString() + "9"));

        add.setOnClickListener(view -> {
            compute();
            ACTION = ADDITION;
            result.setText(String.valueOf(val1) + "+");
            info.setText(null);
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });



    }

    private void setupOIViews(){

        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine= (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnminus);
        multi = (Button)findViewById(R.id.btnmulti);
        div = (Button)findViewById(R.id.btndivide);
        clear = (Button)findViewById(R.id.btnclear);
        equal= (Button)findViewById(R.id.btnequal);
        info = (TextView)findViewById(R.id.control);
        result = (TextView)findViewById(R.id.result);
    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;

            }
        }
           else{
               val1 = Double.parseDouble(info.getText().toString());
        }
    }
}