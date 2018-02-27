package com.example.chap02_chall_01;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView1;
    ImageView imgView2;
    ScrollView scrollView1;
    ScrollView scrollView2;
    BitmapDrawable bitmap;

    int bitWidth;
    int bitHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView1 = (ScrollView) findViewById(R.id.scrView1);
        scrollView2 = (ScrollView) findViewById(R.id.scrView2);
        imgView1 = (ImageView) findViewById(R.id.imgView1);
        imgView2 = (ImageView) findViewById(R.id.imgView2);

        scrollView1.setHorizontalScrollBarEnabled(true);
        scrollView2.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.imgtest);
        bitWidth = bitmap.getIntrinsicWidth();
        bitHeight = bitmap.getIntrinsicHeight();

        imgView1.setImageDrawable(bitmap);
        imgView1.getLayoutParams().width = bitWidth;
        imgView1.getLayoutParams().height = bitHeight;
    }

    public void onUpClick(View view) {
        imgView2.setImageDrawable(null);

        imgView1.setImageDrawable(bitmap);
        imgView1.getLayoutParams().width = bitWidth;
        imgView1.getLayoutParams().height = bitHeight;
    }

    public void onDownClick(View view) {
        imgView1.setImageDrawable(null);

        imgView2.setImageDrawable(bitmap);
        imgView2.getLayoutParams().width = bitWidth;
        imgView2.getLayoutParams().height = bitHeight;
    }
}

