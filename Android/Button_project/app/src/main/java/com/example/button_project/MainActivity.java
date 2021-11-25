package com.example.button_project;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button1, button2;
    RadioGroup radioGroup;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditText1);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        radioGroup = findViewById(R.id.RadioGroup);
        imageView = findViewById(R.id.ImageView1);

        button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
           }
        });

        button2.setOnClickListener(v ->{
           Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
           startActivity(mIntent);
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.RButton1:
                        imageView.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RButton2:
                        imageView.setImageResource(R.drawable.r11);
                        break;
                }
            }
        });
    }
}