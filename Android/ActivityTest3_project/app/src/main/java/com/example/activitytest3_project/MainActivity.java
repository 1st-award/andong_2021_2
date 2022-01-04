package com.example.activitytest3_project;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rGroup = findViewById(R.id.RadioGroup1);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.GotoSecondPage:
                        intent = new Intent(getApplicationContext(), SecondActivity.class);
                        break;
                    case R.id.GotoThirdPage:
                        intent = new Intent(getApplicationContext(), ThirdActivity.class);
                        break;
                }
            }
        });

        Button button = findViewById(R.id.GotoPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intent == null)
                    Toast.makeText(getApplicationContext(), "페이지를 선택해주세요", Toast.LENGTH_SHORT).show();
                else {
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}