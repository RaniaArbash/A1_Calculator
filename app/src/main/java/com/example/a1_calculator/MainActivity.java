package com.example.a1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button plus_btn;
    Button one_digit;
    Button equal_op;
    Button clear;
    Button advance;
    TextView result;
    Calculator_Brain model;
    String calcualtion_string = "";
    TextView history_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Calculator_Brain();
//        plus_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        one_digit = findViewById(R.id.num1);
        plus_btn = findViewById(R.id.plus_ope);
        equal_op = findViewById(R.id.equal_op);
        clear = findViewById(R.id.clear);
        result = findViewById(R.id.standerResult);
        advance = findViewById(R.id.advance_button);
        history_text = findViewById(R.id.advanceResult);


        one_digit.setOnClickListener(this);
        plus_btn.setOnClickListener(this);
        equal_op.setOnClickListener(this);
        clear.setOnClickListener(this);
        advance.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.advance_button){
            if (model.mode == 1){
                ((Button)view).setText("Standard - No History");
                model.toAdvanceMode();
                history_text.setVisibility(View.VISIBLE);

            } else { // in advance
                ((Button)view).setText("Advanced - With History");

                model.toStanderdMode();
                history_text.setVisibility(View.INVISIBLE);
            }
        }
        else
        if (view.getId() == R.id.clear){
            Log.d("Calcualtor","Clear clicked");    // C
            result.setText("");
            calcualtion_string = "";
            model.clear();
        }
        else if (view.getId() == R.id.equal_op){
            Log.d("Calcualtor","equal  clicked"); // =
            int r = model.calc();
            calcualtion_string = calcualtion_string + " = " + r;
            result.setText(calcualtion_string );
            if (model.mode == 2) {
                history_text.setText(model.getHistory());
            }
        }
        else {
            String v = ((Button)view).getText().toString(); // 1 2 + -
            calcualtion_string = calcualtion_string + "  " + v;
            result.setText(calcualtion_string);
            model.push(v);
            Log.d("Calcualtor","number or Op clicked"); // 2 + 3 + 4 - 5

        }

    }
//    public void num2_clicked(View view) {
//
//    }
}