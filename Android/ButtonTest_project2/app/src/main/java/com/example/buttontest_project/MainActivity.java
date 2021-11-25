package com.example.buttontest_project;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;
    Intent openNate = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
    Intent call911 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
    Intent openGallery = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        button3 = findViewById(R.id.Button3);
        button4 = findViewById(R.id.Button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openNate);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(call911);
            }
        });

        button3.setOnClickListener(v -> {
            startActivity(openGallery);
        });

        button4.setOnClickListener(v -> {
            finish();
        });
    }
}