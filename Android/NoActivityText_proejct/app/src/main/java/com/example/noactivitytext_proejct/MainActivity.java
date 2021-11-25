package com.example.noactivitytext_proejct;

import android.graphics.Color;
import android.graphics.Typeface;
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


        TextView view1, view2, view3, view4, view5;
        view1 = new TextView(this);
        view2 = new TextView(this);
        view3 = new TextView(this);
        view4 = new TextView(this);
        view5 = new TextView(this);


        // SET view1
        view1.setTextSize(30);
        view1.setText("textSize 속성");
        baseLayout.addView(view1);

        // SET view2
        view2.setTextSize(30);
        view2.setTextColor(Color.MAGENTA);
        view2.setText("textColor 속성");
        baseLayout.addView(view2);

        // SET view3
        view3.setTextSize(30);
        view3.setTypeface(view3.getTypeface(), Typeface.BOLD_ITALIC);
        view3.setText("typeStyle 속성");
        baseLayout.addView(view3);

        // SET view4
        view4.setTextSize(30);
        view4.setTypeface(Typeface.SERIF);
        view4.setText("typeface 속성");
        baseLayout.addView(view4);

        // SET view5
        view5.setTextSize(30);
        view5.setSingleLine(true);
        view5.setText("singleLine 속성 singleLine 속성 singleLine 속성 singleLine 속성 singleLine 속성 singleLine 속성 singleLine 속성");
        baseLayout.addView(view5);
    }
}