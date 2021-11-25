package com.example.inputphonenumber_project;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        // Toast Event
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEditTextMessage = editText.getText().toString();
                Toast.makeText(getApplicationContext(), getEditTextMessage, Toast.LENGTH_SHORT).show();
            }
        });
        // Cancel Event
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }
}