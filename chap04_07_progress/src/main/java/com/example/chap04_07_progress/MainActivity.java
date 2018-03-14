package com.example.chap04_07_progress;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
TextView txtViewSeek;

    private int brightness = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar prgBar = findViewById(R.id.prgBar);
        prgBar.setIndeterminate(false);
        prgBar.setMax(100);
        prgBar.setProgress(60);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                progressDialog = new ProgressDialog(getApplicationContext());
//                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                progressDialog.setMessage("로딩중..");
//
//                progressDialog.show();
                showProgressDialog("로딩중..");
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressDialog != null){
                    progressDialog.dismiss();
                }
            }
        });

        txtViewSeek = findViewById(R.id.txtViewSeek);

        Button btnSeekView = findViewById(R.id.btnSeekView);
        btnSeekView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout  seekPanel = findViewById(R.id.seekPanel);
                seekPanel.setVisibility(View.VISIBLE);
            }
        });

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setBrightness(int progress) {
        if(progress < 10){
            progress = 10;
        }else if(progress >100){
            progress = 100;
        }

        // 이건 무엇?
        brightness =progress;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) progress / 100;
        getWindow().setAttributes(params);

        txtViewSeek.setText("SeekBar 값"+ progress);

    }

    private void showProgressDialog(String message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);

        progressDialog.show();
    }
}
