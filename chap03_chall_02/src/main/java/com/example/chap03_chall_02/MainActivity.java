package com.example.chap03_chall_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void onLogin(View v)
    {
        EditText id = findViewById(R.id.txtId);
        EditText pw = findViewById(R.id.txtPw);

        if (id.getText().toString().equals("") ||  pw.getText().toString().equals("")){
            Toast.makeText(this, "아이디/비밀번호 입력하세요", Toast.LENGTH_LONG).show();
            return;
        }else {
            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            startActivityForResult(intent, REQ_CODE);
        }
    }

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
