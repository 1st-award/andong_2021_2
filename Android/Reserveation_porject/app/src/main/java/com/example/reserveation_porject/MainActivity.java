package com.example.reserveation_porject;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnEnd;
    TextView tvYear, tvMonth, tvDate, tvHour, tvMinute;
    RadioButton rdoCal, rdoTime;
    Chronometer cm;
    TimePicker tp;
    CalendarView cv;
    Integer setYear, setMonth, setDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        cm = (Chronometer) findViewById(R.id.chronometer1);
        tp = (TimePicker) findViewById(R.id.timePicker1);
        cv = (CalendarView) findViewById(R.id.calendarView1);

        tp.setVisibility(View.INVISIBLE);
        cv.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.setBase(SystemClock.elapsedRealtime());
                cm.start();
                cm.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               cm.stop();
               cm.setTextColor(Color.BLUE);

               tvYear.setText(Integer.toString(setYear));
               tvMonth.setText(Integer.toString(setMonth));
               tvDate.setText(Integer.toString(setDate));

               tvHour.setText(Integer.toString(tp.getCurrentHour()));
               tvMinute.setText(Integer.toString(tp.getCurrentMinute()));
           }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.setVisibility(View.VISIBLE);
                tp.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.VISIBLE);
            }
        });

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int date) {
                setYear = year;
                setMonth = month+1;
                setDate = date;
            }
        });
    }
}