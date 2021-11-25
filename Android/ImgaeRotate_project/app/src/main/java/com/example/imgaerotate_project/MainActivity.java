package com.example.imgaerotate_project;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton1;
    ImageView imageView1;
    float getRotationValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton1 = (ImageButton) findViewById(R.id.ImageButton1);
        imageView1 = (ImageView) findViewById(R.id.ImageView1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(360 == getRotationValue)
                    getRotationValue = 0;
                getRotationValue += 10;
                imageView1.setRotation(getRotationValue);
                System.out.println(getRotationValue);
            }
        });
    }
}