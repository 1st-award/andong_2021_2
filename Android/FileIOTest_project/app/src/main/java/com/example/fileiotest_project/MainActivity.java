package com.example.fileiotest_project;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button writeFile, readFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeFile = (Button) findViewById(R.id.writeFile);
        readFile = (Button) findViewById(R.id.readFile);

        writeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFS = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "Hello World!";
                    outFS.write(str.getBytes());
                    outFS.close();
                } catch(IOException e) {}
            }
        });

        readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inFS = openFileInput("file.txt");
                    byte[] str = new byte[30];
                    inFS.read(str);
                    String txt = new String(str);
                    Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
                } catch(IOException e) {}
            }
        });
    }
}