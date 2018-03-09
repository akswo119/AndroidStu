package com.example.chap03_04_parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by BK on 2018-03-07.
 */

public class menuActivity extends AppCompatActivity {

    public static final String KEY_DATA = "data";
    TextView txtView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        txtView1 = findViewById(R.id.txtView1);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent){
        if (intent != null){
            Bundle bundle = intent.getExtras();

            parcel data = (parcel)bundle.getParcelable(KEY_DATA);

            txtView1.setText("전달 받은 데이터 \nint A:" + data.getA() + "\nStirng B:" + data.getB() + "\nString C:" + data.getC());
        }
    }
}
