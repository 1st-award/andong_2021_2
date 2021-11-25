package com.example.calculate_project;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button addButton, subButton, mulButton, divButton;
    TextView textView1;
    String num1, num2;
    Integer result;
    Button[] numPadButtons = new Button[10];
    Integer[] numPadButtonNumbers = {R.id.Button0, R.id.Button1, R.id.Button2, R.id.Button3, R.id.Button4, R.id.Button5,
    R.id.Button6, R.id.Button7, R.id.Button8, R.id.Button9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.EditText1);
        editText2 = (EditText) findViewById(R.id.EditText2);
        textView1 = (TextView) findViewById(R.id.TextView1);
        addButton = (Button) findViewById(R.id.ButtonAdd);
        subButton = (Button) findViewById(R.id.ButtonSub);
        mulButton = (Button) findViewById(R.id.ButtonMul);
        divButton = (Button) findViewById(R.id.ButtonDiv);

        for(int i=0; i<10; ++i) {
            numPadButtons[i] = (Button) findViewById(numPadButtonNumbers[i]);
        }
        for(int i=0; i<10; ++i) {
            final int index;
            index = i;
            numPadButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(editText1.isFocused() == true) {
                        num1 = editText1.getText().toString()
                                + numPadButtons[index].getText().toString();
                        System.out.println(num1);
                        editText1.setText(num1);
                    } else if(editText2.isFocused() == true) {
                        num2 = editText2.getText().toString()
                                + numPadButtons[index].getText().toString();
                        editText2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        addButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                int digit1 = Integer.parseInt(num1);
                int digit2 = Integer.parseInt(num2);
                result = digit1 + digit2;
                textView1.setText(result.toString());
                return false;
            }
        });

        subButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                int digit1 = Integer.parseInt(num1);
                int digit2 = Integer.parseInt(num2);
                result = digit1 - digit2;
                textView1.setText(result.toString());
                return false;
            }
        });

        mulButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                int digit1 = Integer.parseInt(num1);
                int digit2 = Integer.parseInt(num2);
                result = digit1 * digit2;
                textView1.setText(result.toString());
                return false;
            }
        });

        divButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                int digit1 = Integer.parseInt(num1);
                int digit2 = Integer.parseInt(num2);
                result = digit1 / digit2;
                textView1.setText(result.toString());
                return false;
            }
        });
    }
}