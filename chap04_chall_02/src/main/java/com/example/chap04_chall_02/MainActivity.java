package com.example.chap04_chall_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;
    Animation upAmim;
    Animation downAmim;
    LinearLayout searchArea;
    Button btnShow;
    Button btnLoad;
    WebView webView;
    EditText urlInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchArea = findViewById(R.id.searchArea);
        upAmim = AnimationUtils.loadAnimation(this, R.anim.up_move);
        downAmim = AnimationUtils.loadAnimation(this, R.anim.down_move);

        urlInput = findViewById(R.id.urlInput);
        webView = findViewById(R.id.webView);

        SlidingPageAnimationListener  animationListner = new  SlidingPageAnimationListener();

        upAmim.setAnimationListener(animationListner);
        downAmim.setAnimationListener(animationListner);

        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen){
                    searchArea.startAnimation(upAmim);
                } else{
                    searchArea.startAnimation(downAmim);
                }
            }
        });

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchArea.startAnimation(upAmim);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(urlInput.getText().toString());
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
                btnShow.setText("▽");
                isPageOpen = false;
                searchArea.setVisibility(View.GONE);
            } else{
                btnShow.setText("△");
                isPageOpen = true;
                searchArea.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
