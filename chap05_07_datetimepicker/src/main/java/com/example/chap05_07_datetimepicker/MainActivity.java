package com.example.chap05_07_datetimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

    TextView textView;
    DateTimePicker dateTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        dateTimePicker = findViewById(R.id.dateTimePicker);

        dateTimePicker.setOnDateTimeChangedListner(new DateTimePicker.OnDateTimeChangedListner() {
            @Override
            public void onDateTimeChanged(DateTimePicker view, int year, int montOfYear, int dayOfYear, int hour, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, montOfYear, dayOfYear, hour, minute);

                textView.setText(dateFormat.format(calendar.getTime()));
            }
        });

    }
}
