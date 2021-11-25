package com.example.noactivitylinearlayout_project;

import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1;

        LinearLayout.LayoutParams widgetParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, layoutParams);

        LinearLayout firstLayout = new LinearLayout(this);
        firstLayout.setOrientation(LinearLayout.VERTICAL);
        firstLayout.setGravity(Gravity.CENTER);
        firstLayout.setLayoutParams(params);
        Button button1 = new Button(this);
        Button button2 = new Button(this);
        button1.setLayoutParams(widgetParams);  button2.setLayoutParams(widgetParams);
        firstLayout.addView(button1);   firstLayout.addView(button2);
        baseLayout.addView(firstLayout);


        LinearLayout secondLayout = new LinearLayout(this);
        secondLayout.setOrientation(LinearLayout.HORIZONTAL);
        secondLayout.setGravity(Gravity.CENTER);
        secondLayout.setLayoutParams(params);
        secondLayout.setBackgroundColor(Color.GREEN);
        Button button3 = new Button(this);
        button3.setBackgroundColor(Color.GREEN);
        Button button4 = new Button(this);
        button4.setBackgroundColor(Color.GREEN);
        button3.setLayoutParams(widgetParams);  button4.setLayoutParams(widgetParams);
        secondLayout.addView(button3);  secondLayout.addView(button4);
        baseLayout.addView(secondLayout);


        LinearLayout thirdLayout = new LinearLayout(this);
        thirdLayout.setOrientation(LinearLayout.VERTICAL);
        thirdLayout.setGravity(Gravity.CENTER);
        thirdLayout.setLayoutParams(params);
        thirdLayout.setBackgroundColor(Color.BLUE);
        Button button5 = new Button(this);
        button5.setBackgroundColor(Color.BLUE);
        Button button6 = new Button(this);
        button6.setBackgroundColor(Color.BLUE);
        button5.setLayoutParams(widgetParams);  button6.setLayoutParams(widgetParams);
        thirdLayout.addView(button5);   thirdLayout.addView(button6);
        baseLayout.addView(thirdLayout);
    }
}