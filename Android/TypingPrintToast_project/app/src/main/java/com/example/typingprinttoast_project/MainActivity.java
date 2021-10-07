package com.example.typingprinttoast_project;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 4-8");

        editText1 = (EditText) findViewById(R.id.EditText1);
        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                System.out.println(editText1.getText().toString());
                Toast.makeText(getApplicationContext(), editText1.getText().toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}