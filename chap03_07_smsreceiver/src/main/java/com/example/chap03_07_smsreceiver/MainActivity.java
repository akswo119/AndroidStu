package com.example.chap03_07_smsreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.txtV1);
        editText2 = (EditText)findViewById(R.id.txtV2);
        editText3 = (EditText)findViewById(R.id.txtV3);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();                
                
            }
        });

        Intent intent = getIntent();
        ProcessIntent(intent);
        
    }

    @Override
    protected void onNewIntent(Intent intent){
        ProcessIntent(intent);
        super.onNewIntent(intent);
    }

    private void ProcessIntent(Intent intent) {
        if (intent !=null){
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            editText1.setText(sender);
            editText2.setText(contents);
            editText3.setText(receivedDate);

        }

    }
}
