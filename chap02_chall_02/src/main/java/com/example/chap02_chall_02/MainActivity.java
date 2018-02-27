package com.example.chap02_chall_02;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText mainText;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.txtMain);
        textView1= findViewById(R.id.txtViewLenth);

        String txt = String.format(getResources().getString(R.string.byteText), getResources().getString(R.string.zeroText));
        textView1.setText(txt);

        mainText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String txt = String.format(getResources().getString(R.string.byteText), String.valueOf(charSequence.length())) ;
                textView1.setText(txt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onSendClick(View view) {
        Toast.makeText(this, mainText.getText(), Toast.LENGTH_LONG).show();
    }
}
