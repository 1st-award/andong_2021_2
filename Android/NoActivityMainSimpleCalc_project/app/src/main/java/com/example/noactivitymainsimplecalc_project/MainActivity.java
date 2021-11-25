package com.example.noactivitymainsimplecalc_project;

import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout.LayoutParams widgetParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout);

        EditText editText1 = new EditText(this);
        editText1.setLayoutParams(widgetParams);
        editText1.setHint("숫자1");
        EditText editText2 = new EditText(this);
        editText2.setLayoutParams(widgetParams);
        editText2.setHint("숫자2");
        baseLayout.addView(editText1);  baseLayout.addView(editText2);

        Button button1 = new Button(this);
        Button button2 = new Button(this);
        Button button3 = new Button(this);
        Button button4 = new Button(this);
        baseLayout.addView(button1);    baseLayout.addView(button2);    baseLayout.addView(button3);    baseLayout.addView(button4);

        TextView textView = new TextView(this);
        textView.setTextColor(Color.RED);
        textView.setTextSize(30);
        textView.setText("계산 결과: ");
        baseLayout.addView(textView);

        button1.setText("더하기");
        button1.setOnClickListener(v -> {
           String num1 = editText1.getText().toString();
           String num2 = editText2.getText().toString();
           int number1 = Integer.parseInt(num1);
           int number2 = Integer.parseInt(num2);
           String result =  Integer.toString(number1 + number2);
           textView.setText("계산 결과: " + result);
        });

        button2.setText("빼기");
        button2.setOnClickListener(v -> {
            String num1 = editText1.getText().toString();
            String num2 = editText2.getText().toString();
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            String result =  Integer.toString(number1 - number2);
            textView.setText("계산 결과: " + result);
        });

        button3.setText("곱하기");
        button3.setOnClickListener(v -> {
            String num1 = editText1.getText().toString();
            String num2 = editText2.getText().toString();
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            String result =  Integer.toString(number1 * number2);
            textView.setText("계산 결과: " + result);
        });

        button4.setText("나누기");
        button4.setOnClickListener(v -> {
            String num1 = editText1.getText().toString();
            String num2 = editText2.getText().toString();
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            String result =  Integer.toString(number1 / number2);
            textView.setText("계산 결과: " + result);
        });
    }
}