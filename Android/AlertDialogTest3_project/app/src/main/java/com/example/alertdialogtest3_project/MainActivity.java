package com.example.alertdialogtest3_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText tvName, tvEmail, diaEdtName, diaEdtEmail;
    Button button1;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력(수정)");

        tvName = (EditText) findViewById(R.id.mainEdtName);
        tvEmail = (EditText) findViewById(R.id.mainEdtEmail);
        button1 = (Button) findViewById(R.id.mainButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        diaEdtName = (EditText) dialogView.findViewById(R.id.diaEdtText1);
                        diaEdtEmail = (EditText) dialogView.findViewById(R.id.diaEdtText2);

                        tvName.setText(diaEdtName.getText().toString());
                        tvEmail.setText(diaEdtEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Random random = new Random();
                        int offsetX = random.nextInt(1080);
                        int offsetY = random.nextInt(1920);
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastTextView);

                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT, offsetX, offsetY);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}