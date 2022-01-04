package com.example.reservationtest2_project;

import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.versionedparcelable.VersionedParcelize;

public class MainActivity extends AppCompatActivity {
    TextView tvYear, tvMonth, tvDate, tvHour, tvMinute;
    RadioButton doDate, doTime;
    Chronometer chronometer;
    TimePicker timePicker;
    DatePicker datePicker;
    Integer setYear, setMonth, setDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약(수정)");

        tvYear = findViewById(R.id.tvYear);
        tvMonth= findViewById(R.id.tvMonth);
        tvDate = findViewById(R.id.tvDate);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        doDate = findViewById(R.id.rdoCal);
        doTime = findViewById(R.id.rdoTime);

        chronometer = findViewById(R.id.chronometer1);
        timePicker = findViewById(R.id.timepicker1);
        datePicker = findViewById(R.id.datepicker1);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(setYear));
                tvMonth.setText(Integer.toString(setMonth));
                tvDate.setText(Integer.toString(setDate));
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
                return false;
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    setYear = year;
                    setMonth = monthOfYear + 1;
                    setDate = dayOfMonth;
                }
            });
        }

        doDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        doTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });
    }
}