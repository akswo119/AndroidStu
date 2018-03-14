package com.example.chap04_01_touchevent;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtView1;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView1 = findViewById(R.id.txtView1);

        View view1 = findViewById(R.id.view1);
        view1.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int act = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if (act == MotionEvent.ACTION_DOWN){
                    writeTxt("ACTION_DOWN : 손가락 눌림 :" + curX + "," + curY);
                } else if (act == MotionEvent.ACTION_MOVE){
                    writeTxt("ACTION_MOVE 손가락 이동 :" + curX + "," + curY);
                } else if (act == MotionEvent.ACTION_UP){
                    writeTxt("ACTION_UP 손가락 떔 :" + curX + "," + curY);
                }

                return  true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {

            @Override
            public boolean onDown(MotionEvent e) {
                writeTxt("onDown() Call");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                writeTxt("onShowPress() Call");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                writeTxt("onSingleTapUp() Call");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                writeTxt("onScroll() Call");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                writeTxt("onLongPress() Call");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                writeTxt("onFling() Call" + velocityX  + ", " + velocityY);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return  true;
            }
        });
    }

    private void writeTxt(String s) {

        txtView1.append(s + "\n");
    }

    public void onClear(View v)
    {
        txtView1.setText("");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "System [Back] 누름", Toast.LENGTH_LONG).show();
            return  true;
        }
            return  false;
    }
}
