package com.example.chap05_08_carendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView monthView;

    MonthAdapter monthViewAdapter;

    TextView monthText;

    int curYear;

    int curMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        monthView = (GridView) findViewById(R.id.gridView);
        monthViewAdapter = new MonthAdapter(this);
        monthView.setAdapter(monthViewAdapter);


        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position);
                int day = curItem.getDay();

                Log.d("MainActivity", "Selected : " + day);
            }
        });


        monthText = (TextView) findViewById(R.id.txtDate);
        setMonthText();


        Button monthPrevious = (Button) findViewById(R.id.btnPrev);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });


        Button monthNext = (Button) findViewById(R.id.btnNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

    }

     private void setMonthText() {
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();

        monthText.setText(curYear + "년 " + (curMonth + 1) + "월");
    }
}
