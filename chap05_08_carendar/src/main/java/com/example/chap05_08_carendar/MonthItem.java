package com.example.chap05_08_carendar;

/**
 * Created by BK on 2018-03-26.
 */

public class MonthItem {

    private int dayValue;

    public MonthItem() {

    }

    public MonthItem(int day) {
        dayValue = day;
    }

    public int getDay() {
        return dayValue;
    }

    public void setDay(int day) {
        this.dayValue = day;
    }
}
