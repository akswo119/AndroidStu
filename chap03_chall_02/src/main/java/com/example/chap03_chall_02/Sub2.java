package com.example.chap03_chall_02;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by BK on 2018-03-07.
 */

public class Sub2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);
    }

    public  void onMenu(View v) throws PackageManager.NameNotFoundException {

        Intent intent = new Intent();

        ActivityInfo activityInfo = getPackageManager().getActivityInfo(
                getComponentName(), PackageManager.GET_META_DATA);
        String title = activityInfo.loadLabel(getPackageManager())
                .toString();

        intent.putExtra("name", title);
        intent.putExtra("isLogin", false);
        setResult(RESULT_OK, intent);

        finish();
    }

    public  void onLogin(View v) throws PackageManager.NameNotFoundException {
        Intent intent = new Intent();

        ActivityInfo activityInfo = getPackageManager().getActivityInfo(
                getComponentName(), PackageManager.GET_META_DATA);
        String title = activityInfo.loadLabel(getPackageManager())
                .toString();

        Boolean isLogin = true;
        intent.putExtra("name", title);
        intent.putExtra("isLogin", true);
        setResult(RESULT_OK, intent);

        finish();
    }
}