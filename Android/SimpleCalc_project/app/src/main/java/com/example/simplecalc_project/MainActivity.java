package com.example.simplecalc_project;

import android.util.AndroidException;
import android.util.AndroidRuntimeException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button addButton, subButton, mulButton, divButton, remButton;
    TextView textResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        // 입력 받는 EditText
        edit1 = (EditText) findViewById(R.id.EditText1);
        edit2 = (EditText) findViewById(R.id.EditText2);

        // 입력 후 계산하는 Button
        addButton = (Button) findViewById(R.id.Button1);
        subButton = (Button) findViewById(R.id.Button2);
        mulButton = (Button) findViewById(R.id.Button3);
        divButton = (Button) findViewById(R.id.Button4);
        remButton = (Button) findViewById(R.id.Button5);

        // 계산 후 값을 출력하는 TextView
        textResult = (TextView) findViewById(R.id.TextView1);

        // 더하기 버튼을 눌렀을 때
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                } catch (java.lang.NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하고 눌러주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 빼기 버튼을 눌렀을 때
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                } catch (java.lang.NumberFormatException e) {   // 값을 입력하지 않고 버튼을 클릭했을 때의 예외처리
                    Toast.makeText(getApplicationContext(), "숫자를 입력하고 눌러주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 곱하기 버튼을 눌렀을 때
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                } catch (java.lang.NumberFormatException e) {   // 값을 입력하지 않고 버튼을 클릭했을 때의 예외처리
                    Toast.makeText(getApplicationContext(), "숫자를 입력하고 눌러주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 나누기 버튼을 눌렀을 때
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    // 0으로 나누면 토스트 메시지를 나타내고 계산하지 않는다
                    if (num2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                } catch (java.lang.NumberFormatException e) {   // 값을 입력하지 않고 버튼을 클릭했을 때의 예외처리
                    Toast.makeText(getApplicationContext(), "숫자를 입력하고 눌러주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 나머지 버튼을 눌렀을 때
        remButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    // 0으로 나누면 토스트 메시지를 나타내고 계산하지 않는다
                    if (num2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                } catch (java.lang.NumberFormatException e) {   // 값을 입력하지 않고 버튼을 클릭했을 때의 예외처리
                    Toast.makeText(getApplicationContext(), "숫자를 입력하고 눌러주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}