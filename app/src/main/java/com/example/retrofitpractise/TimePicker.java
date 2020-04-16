package com.example.retrofitpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class TimePicker extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    Button button, button2;
    TextView textView, textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        button = findViewById(R.id.btntm);
        button2 = findViewById(R.id.btnDate);
        textView = findViewById(R.id.tm);
        textView1 = findViewById(R.id.tm1);
        textView2 = findViewById(R.id.tm2);
        //TimeDatetest timeDatetest = new TimeDatetest()
        Calendar calendar = Calendar.getInstance();
        textView1.setText(calendar.get(Calendar.HOUR)+" : "+calendar.get(Calendar.MINUTE)+" : "+calendar.get(Calendar.SECOND));
        textView2.setText(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)+" : "+calendar.get(Calendar.MONTH)+" : "+calendar.get(Calendar.YEAR));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new tpFragment();
                timepicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dateline = new datepicker();
                dateline.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    /*@Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    }*/

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        textView.setText("Hour"+hourOfDay+"Minute"+minute);
    }
    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

    }

}
