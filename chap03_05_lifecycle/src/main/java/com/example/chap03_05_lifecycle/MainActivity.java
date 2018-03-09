package com.example.chap03_05_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(this.getPackageName(), "onCread()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.getPackageName(), "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.getPackageName(), "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.getPackageName(), "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.getPackageName(), "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public File getNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }
}
