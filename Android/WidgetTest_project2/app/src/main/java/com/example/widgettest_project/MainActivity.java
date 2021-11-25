package com.example.widgettest_project;

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
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout.LayoutParams widgetParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams verticalWidgetParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        Button button1 = new Button(this);
        Button button2 = new Button(this);
        TextView textView1 = new TextView(this);
        EditText editText1 = new EditText(this);


        // SET BUTTON1
        button1.setBackgroundColor(Color.CYAN);
        button1.setLayoutParams(widgetParams);
        button1.setText("버튼 1");
        button1.setEnabled(false);
        baseLayout.addView(button1);

        // SET TEXTVIEW1
        textView1.setVisibility(View.VISIBLE);
        textView1.setText("이것은 텍스트뷰입니다.");
        baseLayout.addView(textView1);

        // SET EDITTEXT1
        editText1.setBackgroundColor(Color.BLUE);
        editText1.setEnabled(false);
        editText1.setHint("이건 에디트텍스트 입니다.");
        baseLayout.addView(editText1);

        // SET BUTTON2
        button2.setLayoutParams(verticalWidgetParams);
        button2.setText("버튼 2");
        baseLayout.addView(button2);
    }
}