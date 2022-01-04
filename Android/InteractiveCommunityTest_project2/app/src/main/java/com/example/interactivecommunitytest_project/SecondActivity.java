package com.example.interactivecommunitytest_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second Activity");

        Intent intent = getIntent();
        final int mode = intent.getIntExtra("Mode", 0);
        String resultValue = null;
        switch (mode) {
            case R.id.btnPlus:
                resultValue = Integer.toString(intent.getIntExtra("Num1", 0) + intent.getIntExtra("Num2", 0));
                break;
            case R.id.btnMinus:
                resultValue = Integer.toString(intent.getIntExtra("Num1", 0) - intent.getIntExtra("Num2", 0));
                break;
            case R.id.btnMultiply:
                resultValue = Integer.toString(intent.getIntExtra("Num1", 0) * intent.getIntExtra("Num2", 0));
                break;
            case R.id.btnDivider:
                resultValue = Double.toString(intent.getIntExtra("Num1", 0) / intent.getIntExtra("Num2", 0));
                break;
        }

        String finalResultValue = resultValue;
        Button backButton = findViewById(R.id.gotoHome);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Result", finalResultValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
