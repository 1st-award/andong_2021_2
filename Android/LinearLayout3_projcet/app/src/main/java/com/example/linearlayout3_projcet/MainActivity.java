package com.example.linearlayout3_projcet;

import android.graphics.Color;
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
        layoutParams.weight=1;

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, layoutParams);

        LinearLayout firstLayout = new LinearLayout(this);
        firstLayout.setOrientation(LinearLayout.HORIZONTAL);
        firstLayout.setLayoutParams(layoutParams);
        baseLayout.addView(baseLayout);

        LinearLayout subFirstLayout1 = new LinearLayout(this);
        subFirstLayout1.setBackgroundColor(Color.RED);
        subFirstLayout1.setLayoutParams(layoutParams);
        firstLayout.addView(subFirstLayout1);

        LinearLayout secondLayout = new LinearLayout(this);
        secondLayout.setOrientation(LinearLayout.VERTICAL);
        secondLayout.setLayoutParams(layoutParams);
        firstLayout.addView(secondLayout);

        LinearLayout subSecondLayout1 = new LinearLayout(this);
        subSecondLayout1.setBackgroundColor(Color.YELLOW);
        subSecondLayout1.setLayoutParams(layoutParams);
        secondLayout.addView(subSecondLayout1);

        LinearLayout subSecondLayout2 = new LinearLayout(this);
        subSecondLayout2.setBackgroundColor(Color.BLACK);
        subSecondLayout2.setLayoutParams(layoutParams);
        secondLayout.addView(subSecondLayout2);
    }
}