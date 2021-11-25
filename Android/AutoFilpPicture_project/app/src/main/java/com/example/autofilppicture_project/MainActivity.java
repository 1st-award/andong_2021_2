package com.example.autofilppicture_project;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart, btnStop;
        final ViewFlipper viewFlipper;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        // set start flipping event
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setFlipInterval(1000); // set next page 1sec
                viewFlipper.startFlipping();
                Toast.makeText(getApplicationContext(), "자동 넘기기 시작", Toast.LENGTH_SHORT).show();
            }
        });

        // set stop flipping event
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
                Toast.makeText(getApplicationContext(), "자동 넘기기 종료", Toast.LENGTH_SHORT).show();
            }
        });
    }
}