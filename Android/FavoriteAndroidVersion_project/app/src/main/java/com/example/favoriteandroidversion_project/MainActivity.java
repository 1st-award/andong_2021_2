package com.example.favoriteandroidversion_project;

import android.media.Image;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2;
    Switch switch1;
    RadioGroup radioGroup;
    Button button1, button2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        textView1 = findViewById(R.id.TextView1);
        textView2 = findViewById(R.id.TextView2);
        switch1 = findViewById(R.id.Switch1);
        radioGroup = findViewById(R.id.RadioGroup);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        imageView = findViewById(R.id.ImageView);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    radioGroup.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
                else {
                    radioGroup.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.RButton1:
                        imageView.setImageResource(R.drawable.p9);
                        break;
                    case R.id.RButton2:
                        imageView.setImageResource(R.drawable.q10);
                        break;
                    case R.id.RButton3:
                        imageView.setImageResource(R.drawable.r11);
                        break;
                    default:
                }
            }
        });

        button1.setOnClickListener(v -> {
            finish();
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
                radioGroup.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                imageView.setImageResource(0);
                imageView.setVisibility(View.INVISIBLE);
                switch1.setChecked(false);
            }
        });
    }
}