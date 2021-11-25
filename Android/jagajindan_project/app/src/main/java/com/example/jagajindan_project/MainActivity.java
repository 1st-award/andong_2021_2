package com.example.jagajindan_project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button confirmButton, cancelButton;
    EditText studentID, studentBirth, studentPW;
    SQLiteDatabase studentDB;
    myDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirmButton = (Button) findViewById(R.id.confirmButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        myDBHelper = new myDBHelper(this);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentID = findViewById(R.id.inputStudentID);
                studentBirth = findViewById(R.id.inputBirth);
                studentPW = findViewById(R.id.inputPW);
                studentDB = myDBHelper.getReadableDatabase();

                final String id = studentID.getText().toString();
                final String birth = studentBirth.getText().toString();
                final String pw = studentPW.getText().toString();

                Cursor cursor = studentDB.rawQuery("SELECT * FROM DormStudentList", null);
                while (cursor.moveToNext()) {
                    if (cursor.getString(0).equals(id) && cursor.getString(2).equals(birth) && cursor.getString(3).equals(pw)) {
                        Intent nextPage = new Intent(getApplicationContext(), VoteSelfDiagnosis.class);
                        VoteSelfDiagnosis.studentID = Integer.parseInt(studentID.getText().toString());
                        startActivity(nextPage);
                        return;
                    }
                }
                AlertDialog.Builder noRegister = new AlertDialog.Builder(MainActivity.this);
                noRegister.setTitle("등록되지 않은 관생입니다");
                noRegister.setMessage("관생을 등록하시려면 확인버튼을 눌러주세요.");
                noRegister.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent registerPage = new Intent(getApplicationContext(), RegisterStudent.class);
                        startActivity(registerPage);
                    }
                });
                noRegister.setNegativeButton("취소", null);
                noRegister.show();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}