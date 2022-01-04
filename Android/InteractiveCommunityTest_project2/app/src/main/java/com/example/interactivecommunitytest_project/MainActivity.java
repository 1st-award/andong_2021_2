package com.example.interactivecommunitytest_project;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("First Activity");

        Button gotoCalc = findViewById(R.id.gotoCalc);
        gotoCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.edtNum1);
                EditText num2 = findViewById(R.id.edtNum2);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(num1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(num2.getText().toString()));
                RadioGroup rGroup = findViewById(R.id.rGroup);
                intent.putExtra("Mode", rGroup.getCheckedRadioButtonId());
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String calcResult = data.getStringExtra("Result");
            System.out.println("Result: " + calcResult);
            Toast.makeText(getApplicationContext(), "합계: " + calcResult, Toast.LENGTH_SHORT).show();
        }
    }
}