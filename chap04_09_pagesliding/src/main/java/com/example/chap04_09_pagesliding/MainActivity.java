package com.example.chap04_09_pagesliding;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;
    Animation leftAmim;
    Animation rightAmim;
    LinearLayout page;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);
        leftAmim = AnimationUtils.loadAnimation(this, R.anim.left_move);
        rightAmim = AnimationUtils.loadAnimation(this, R.anim.right_move);
        SlidingPageAnimationListener  animationListner = new  SlidingPageAnimationListener();

        leftAmim.setAnimationListener(animationListner);
        rightAmim.setAnimationListener(animationListner);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen){
                    page.startAnimation(rightAmim);
                } else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(leftAmim);
                }

            }
        });
    }

    private  class SlidingPageAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);

                btn.setText("Open");
                isPageOpen = false;
            } else{
                btn.setText("Close");
                isPageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
