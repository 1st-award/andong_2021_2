package com.example.buttontest_project;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CheckBox enabled, clickable, rotate;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("체크박스 상호작용 테스트");

        enabled = (CheckBox) findViewById(R.id.CheckBox1);
        clickable = (CheckBox) findViewById(R.id.CheckBox2);
        rotate = (CheckBox) findViewById(R.id.CheckBox3);
        button = (Button) findViewById(R.id.Button1);

        enabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if(isChecked)
                    button.setEnabled(true);
                else
                    button.setEnabled(false);
            }
        });

        clickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if(isChecked)
                    button.setClickable(true);
                else
                    button.setClickable(false);
            }
        });

        rotate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if(isChecked)
                    button.setRotation(45);
                else
                    button.setRotation(0);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}