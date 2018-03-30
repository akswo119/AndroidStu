package com.example.chap05_02_bitmapbutton;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by BK on 2018-03-21.
 */

public class BitmapButton extends AppCompatButton{

    int iconNormal = R.drawable.bitmap_button_normal;
    int iconClicked = R.drawable.bitmap_button_clicked;

    Boolean isClicked  = false;

    public BitmapButton(Context context) {
        this(context, null);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        setBackgroundResource(iconNormal);

        int defaultTextColor = Color.WHITE;
        float defaultTextSize = getResources().getDimension(R.dimen.text_size);
        Typeface defaultTypeface = Typeface.DEFAULT_BOLD;

        setTextColor(defaultTextColor);
        setTextSize(defaultTextSize);
        setTypeface(defaultTypeface);

        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        int action = event.getAction();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(iconClicked);
                isClicked = true;

                break;
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundResource(iconNormal);

                isClicked = false;
                break;
        }

        //# 다시그리기
        invalidate();

        return  true;
    }
}
