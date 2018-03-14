package com.example.chap04_03_orientatiion;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@MainActivity@@";

    String name;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() Call");


        editText = findViewById(R.id.editTxt);

        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                Toast.makeText(getApplicationContext(), "변수저장 완료" + name, Toast.LENGTH_LONG).show();
            }
        });

        if (savedInstanceState != null){
            name = savedInstanceState.getString("name");

            Toast.makeText(getApplicationContext(), "변수복원" + name, Toast.LENGTH_LONG).show();
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
        Log.d(TAG, "onSaveInstanceState() Call");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() Call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() Call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() Call");
    }

}
