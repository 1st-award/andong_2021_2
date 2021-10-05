package com.example.favoriteandroidversion_project;

import android.media.Image;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Switch startSwitch;
    RadioGroup radioGroup;
    RadioButton pie, q, r;
    ImageView imageView;
    Button exit, reset;

    // Object 출력 or 비출력 스위칭 함수 (View.VISIBLE -> 0, View.INVISIBLE -> 4)
    private void switchVisible(int switching) {
        textView.setVisibility(switching);
        radioGroup.setVisibility(switching);
        imageView.setVisibility(switching);
        exit.setVisibility(switching);
        reset.setVisibility(switching);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");
        // ** activity_main.xml에 생성한 위젯을 변수에 대입 **
        textView = (TextView) findViewById(R.id.TextView2);
        startSwitch = (Switch) findViewById(R.id.StartSwitch);

        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup1);
        pie = (RadioButton) findViewById(R.id.Pie);
        q = (RadioButton) findViewById(R.id.Q);
        r = (RadioButton) findViewById(R.id.R);

        imageView = (ImageView) findViewById(R.id.ImageView1);
        exit = (Button) findViewById(R.id.Button1);
        reset = (Button) findViewById(R.id.Button2);
        // ***********************************************
        // 시작함 Button On/Off 감지
        startSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                // 시작함 Switch가 On일 때 나머지 Object visible로 변환
                if(startSwitch.isChecked() == true)
                    switchVisible(View.VISIBLE);
                // 시작함 Switch가 Off일 때 Object invisible로 변환
                else
                    switchVisible(View.INVISIBLE);
            }
        });

        // RadioButton들 변화 감지
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // RadioButton 변경에 따라 Image가 바뀜
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.Pie:
                        imageView.setImageResource(R.drawable.p9);
                        break;
                    case R.id.Q:
                        imageView.setImageResource(R.drawable.q10);
                        break;
                    case R.id.R:
                        imageView.setImageResource(R.drawable.r11);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "버전을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 프로그램 종료 버튼
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 시스템 종료 코드
                System.exit(1);
            }
        });

        // 처음으로 가는 버튼
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // image 초기화
                imageView.clearAnimation();
                // Radio Button 체크 초기화
                pie.setChecked(false);
                q.setChecked(false);
                r.setChecked(false);
                // Object invisible
                switchVisible(View.INVISIBLE);
                // 시작함 Switch 체크 초기화
                startSwitch.setChecked(false);
            }
        });
    }
}