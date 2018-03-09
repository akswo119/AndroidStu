package com.example.chap03_chall_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by BK on 2018-03-07.
 */

public class MainMenu extends AppCompatActivity {

    public static final int REQ_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
    }

    public void onSub1(View v) {
        Intent intent = new Intent(getApplicationContext(), Sub1.class);
        startActivityForResult(intent, REQ_CODE);
    }
    public void onSub2(View v) {
        Intent intent = new Intent(getApplicationContext(), Sub2.class);
        startActivityForResult(intent, REQ_CODE);
    }
    public void onSub3(View v) {
        Intent intent = new Intent(getApplicationContext(), Sub3.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                Boolean isLogin = data.getExtras().getBoolean("isLogin");
                if (isLogin){
                    Intent intent = new Intent();

                    String ret = data.getExtras().getString("name");
                    intent.putExtra("name", ret);
                    setResult(RESULT_OK, intent);

                    finish();
                }else {
                    String name = data.getExtras().getString("name");
                    Toast.makeText(this, name, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}