package com.example.chap03_06_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTxt1);

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if(intent != null){
            if(intent != null){
                String command = intent.getStringExtra("command");
                String name = intent.getStringExtra("name");

                Toast.makeText(this, "command: " + command + " name: " + name, Toast.LENGTH_LONG).show();
            }
        }
    }

    public  void onBtnClick(View v){
        String name = editText.getText().toString();

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", name);
        startService(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
       processIntent(intent);

        super.onNewIntent(intent);
    }
}
