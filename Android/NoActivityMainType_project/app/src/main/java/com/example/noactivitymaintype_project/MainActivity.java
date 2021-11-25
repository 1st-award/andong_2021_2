package com.example.noactivitymaintype_project;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
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
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
                System.out.printf("%s %d %s\n", v.toString(), keyCode, keyEvent.toString());
                Toast.makeText(getApplication(), editText.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        baseLayout.addView(editText);
    }
}