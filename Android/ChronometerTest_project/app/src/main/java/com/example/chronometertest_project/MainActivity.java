package com.example.chronometertest_project;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chronometer cm = (Chronometer) findViewById(R.id.chronometer);

        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.start();
                Toast.makeText(getApplicationContext(), "chronometer start", Toast.LENGTH_SHORT).show();
            }
        });

        cm.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cm.stop();
                Toast.makeText(getApplicationContext(), "chorometer stop", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}