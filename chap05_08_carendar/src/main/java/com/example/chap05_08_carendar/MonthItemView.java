package com.example.chap05_08_carendar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by BK on 2018-03-26.
 */

public class MonthItemView extends AppCompatButton{
    private MonthItem item;

    public MonthItemView(Context context) {
        super(context);

        init();
    }

    public MonthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        //setBackgroundColor(Color.WHITE);
        setGravity(Gravity.CENTER);
//setPadding(50,50,50,50);
    }


    public MonthItem getItem() {
        return item;
    }

    public void setItem(MonthItem item) {
        this.item = item;

        int day = item.getDay();
        if (day != 0) {
            setText(String.valueOf(day));
        } else {
            setText("");
        }

    }

}
