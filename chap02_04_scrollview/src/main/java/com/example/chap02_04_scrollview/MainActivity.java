package com.example.chap02_04_scrollview;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    ImageView imgView;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imgView = (ImageView) findViewById(R.id.imgView);
        scrollView.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable)res.getDrawable(R.drawable.t1);
        int bitWidth = bitmap.getIntrinsicWidth();
        int bitHeight = bitmap.getIntrinsicHeight();

        imgView.setImageDrawable(bitmap);
        imgView.getLayoutParams().width = bitWidth;
        imgView.getLayoutParams().height = bitHeight;
    }

    Boolean isFirst = true;

    public void onbtn1Clicked(View v){

        Resources res = getResources();

        if (isFirst) {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.t2);
        }
        else
        {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.t1);
        }

        isFirst = !isFirst;

        int bitWidth = bitmap.getIntrinsicWidth();
        int bitHeight = bitmap.getIntrinsicHeight();

        imgView.setImageDrawable(bitmap);
        imgView.getLayoutParams().width = bitWidth;
        imgView.getLayoutParams().height = bitHeight;

    }
}
