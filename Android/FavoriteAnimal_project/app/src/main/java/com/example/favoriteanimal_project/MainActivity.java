package com.example.favoriteanimal_project;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView textView2;
    CheckBox agreeCheck;
    RadioGroup radioGroup1;
    Button selectConfirm;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        textView2 = (TextView) findViewById(R.id.TextView2);
        agreeCheck = (CheckBox) findViewById(R.id.CheckBox1);
        radioGroup1 = (RadioGroup) findViewById(R.id.RadioGroup);
        selectConfirm = (Button) findViewById(R.id.Button1);
        image = (ImageView) findViewById(R.id.ImageView1);

        agreeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                // 시작함 CheckBox가 check되어있을 때
                if(agreeCheck.isChecked() == true) {
                    textView2.setVisibility(View.VISIBLE);
                    radioGroup1.setVisibility(View.VISIBLE);
                    selectConfirm.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                }
                // 시작함 CheckBox가 check되어있지 않을 때
                else {
                    textView2.setVisibility(View.INVISIBLE);
                    radioGroup1.setVisibility(View.INVISIBLE);
                    selectConfirm.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });

        selectConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup1.getCheckedRadioButtonId()) {
                    case R.id.Dog:
                        image.setImageResource(R.drawable.dog);
                        break;
                    case R.id.Cat:
                        image.setImageResource(R.drawable.cat);
                        break;
                    case R.id.Rabbit:
                        image.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}