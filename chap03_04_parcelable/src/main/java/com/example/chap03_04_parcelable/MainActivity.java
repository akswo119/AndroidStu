package com.example.chap03_04_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 101;
    public static final String KEY_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        Intent intent = new Intent(this, menuActivity.class);

        parcel data = new parcel(1, "스트링1", "Stirng2");
        intent.putExtra(KEY_DATA, data);

        startActivityForResult(intent, REQ_CODE);
    }

}
