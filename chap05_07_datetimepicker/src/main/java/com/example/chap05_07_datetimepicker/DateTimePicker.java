package com.example.chap05_07_datetimepicker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by BK on 2018-03-22.
 */

public class DateTimePicker extends LinearLayout {

    public static  interface OnDateTimeChangedListner {
        void onDateTimeChanged(DateTimePicker view, int year, int montOfYear, int dayOfYear, int hour, int minute);
    }

    private  OnDateTimeChangedListner listner;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private CheckBox chkView;


    public DateTimePicker(Context context) {
        this(context, null);
    }

    public DateTimePicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.picker, this, true);

        Calendar calendar = Calendar.getInstance();
        final int curYear = calendar.get(Calendar.YEAR);
        final int curMonth = calendar.get(Calendar.MONTH);
        final int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int curHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int curMinute = calendar.get(Calendar.MINUTE);

        datePicker = findViewById(R.id.datePicker);
        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                if (listner != null) {
                    listner.onDateTimeChanged(DateTimePicker.this, year, monthOfYear, dayOfMonth,
                            timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                }
            }
        });

        chkView = findViewById(R.id.chkView);
        chkView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                timePicker.setEnabled(isChecked);
                timePicker.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
            }
        });

        timePicker = findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (listner != null){
                    listner.onDateTimeChanged(DateTimePicker.this, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                            timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                }
            }
        });

        timePicker.setCurrentHour(curHour);
        timePicker.setCurrentMinute(curMinute);
        timePicker.setEnabled(chkView.isChecked());
        timePicker.setVisibility(chkView.isChecked() ? View.VISIBLE : View.INVISIBLE);
    }

    public void setOnDateTimeChangedListner(OnDateTimeChangedListner dateTimeChangedListner){
        this.listner = dateTimeChangedListner;
    }


    public  void updateDateTime(int year, int montOfYear, int dayOfYear, int hour, int minute){
        datePicker.updateDate(year, montOfYear, dayOfYear);
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minute);
    }
}
