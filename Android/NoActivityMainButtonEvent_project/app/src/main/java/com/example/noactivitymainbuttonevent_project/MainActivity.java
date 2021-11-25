package com.example.noactivitymainbuttonevent_project;

import android.graphics.Color;
import android.graphics.Typeface;
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

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, layoutParams);

        EditText editText = new EditText(this);
        editText.setHint("여기에 입력하세요");
        baseLayout.addView(editText);

        Button button = new Button(this);
        button.setText("버튼입니다");
        baseLayout.addView(button);

        TextView textView = new TextView(this);
        textView.setTextColor(Color.MAGENTA);
        textView.setTextSize(30);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD_ITALIC);
        button.setOnClickListener(v -> {
            textView.setText(editText.getText().toString());
        });
        baseLayout.addView(textView);
    }
}