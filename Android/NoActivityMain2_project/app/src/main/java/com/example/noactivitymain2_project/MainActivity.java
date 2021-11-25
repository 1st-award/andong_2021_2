package com.example.noactivitymain2_project;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        // set LinearLayout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        // set editText
        EditText editText = new EditText(this);
        editText.setHint("여기에 입력하세요");

        // set textView
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setTextColor(Color.MAGENTA);

        // set button
        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEditTextMessage = editText.getText().toString();
                textView.setText(getEditTextMessage);
            }
        });

        // add View
        baseLayout.addView(editText);
        baseLayout.addView(btn);
        baseLayout.addView(textView);
    }
}