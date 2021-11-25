package com.example.noactivitymain_project;

import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        LinearLayout.LayoutParams widgetParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, layoutParams);

        CheckBox checkBox1, checkBox2, checkBox3;
        checkBox1 = new CheckBox(this);
        checkBox2 = new CheckBox(this);
        checkBox3 = new CheckBox(this);

        Button button1;
        button1 = new Button(this);
        button1.setGravity(Gravity.CENTER);
        button1.setLayoutParams(widgetParams);
        button1.setClickable(false);
        button1.setEnabled(false);
        button1.setText("Button1");

        checkBox1.setText("Enabled 속성");
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton c, boolean isChecked) {
                if(isChecked)
                    button1.setEnabled(true);
                else
                    button1.setEnabled(false);
            }
        });
        baseLayout.addView(checkBox1);

        checkBox2.setText("Clickable 속성");
        checkBox2.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked)
                button1.setClickable(true);
            else
                button1.setClickable(false);
        });
        baseLayout.addView(checkBox2);

        checkBox3.setText("45도 회전");
        checkBox3.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked)
                button1.setRotation(45);
            else
                button1.setRotation(0);
        });
        baseLayout.addView(checkBox3);

        baseLayout.addView(button1);
    }
}