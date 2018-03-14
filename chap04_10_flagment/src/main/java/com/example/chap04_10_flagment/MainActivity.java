package com.example.chap04_10_flagment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int i) {
        if (i==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.contaner, mainFragment).commit();
        }else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.contaner, menuFragment).commit();
        }
    }
}
