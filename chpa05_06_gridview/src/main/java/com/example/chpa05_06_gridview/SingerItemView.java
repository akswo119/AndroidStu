package com.example.chpa05_06_gridview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by BK on 2018-03-21.
 */

public class SingerItemView extends LinearLayout {

    TextView txtName;
    TextView txtPhoneNum;
    TextView txtNo;
    ImageView imageView;

    public SingerItemView(Context context) {
        this(context, null);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService((context.LAYOUT_INFLATER_SERVICE));

        layoutInflater.inflate(R.layout.singer_item, this, true);

        txtName = findViewById(R.id.txtName);
        txtPhoneNum = findViewById(R.id.txtPhoneNum);
        txtNo = findViewById(R.id.txtNo);
        imageView = findViewById(R.id.imageView);
    }

    public void setTxtName(String txtName) {
        this.txtName.setText(txtName);
    }

    public void setTxtPhoneNum(String phoneNum) {
        this.txtPhoneNum.setText(phoneNum);
    }

    public void setTxtNo(int no) {
        this.txtNo.setText(String.valueOf(no));
    }

    public void setImageView(int resid) {
        this.imageView.setImageResource(resid);
    }
}
