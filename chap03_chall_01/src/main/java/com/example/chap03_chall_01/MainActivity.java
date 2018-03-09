package com.example.chap03_chall_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), munuActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });
    }
//
//    public void onLogin(View v)
//    {
//        Intent intent = new Intent(this, munuActivity.class);
//        startActivityForResult(intent, REQ_CODE);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE)
        {
            if (resultCode == RESULT_OK){
                String name = data.getExtras().getString("name");
                Toast.makeText(this, name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
