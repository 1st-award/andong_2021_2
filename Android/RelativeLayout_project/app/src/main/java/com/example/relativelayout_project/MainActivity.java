package com.example.relativelayout_project;

import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        RelativeLayout.LayoutParams topWidgetParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        topWidgetParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout baseLayout = new RelativeLayout(this);
        setContentView(baseLayout, layoutParams);

        Button buttonTop = new Button(this);
        buttonTop.setLayoutParams(topWidgetParams);



    }
}