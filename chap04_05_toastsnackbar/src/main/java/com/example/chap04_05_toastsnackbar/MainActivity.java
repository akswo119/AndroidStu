package com.example.chap04_05_toastsnackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onToast(View v) throws InterruptedException {

        Toast toast = Toast.makeText(this, "Toast 메세지~~", Toast.LENGTH_LONG);

        Random random = new Random();
        int x = random.nextInt(300);
        int y = random.nextInt(1200);

        toast.setGravity(Gravity.TOP, x, y);
        toast.show();

    }

    public void onSnackbar(View v){
        Snackbar.make(v, "스낵바~~~~~", Snackbar.LENGTH_LONG).show();
    }

    public void onToastChg(View v){

        LayoutInflater layoutInflater = getLayoutInflater();

        View layout = layoutInflater.inflate(R.layout.toastborder, (ViewGroup)findViewById(R.id.toastLayout));
        TextView textView = layout.findViewById(R.id.text);

        Toast toast = new Toast(this);
        textView.setText("모양바꾼 토스트");
        Random random = new Random();
        int x = random.nextInt(300);
        int y = random.nextInt(1200);

        toast.setGravity(Gravity.TOP, x, y);

        toast.setView(layout);
        toast.show();

    }

}
