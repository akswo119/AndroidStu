package com.example.chap05_chall_01;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by BK on 2018-03-28.
 */

public class SingleItemView extends LinearLayout {

    TextView txtName;
    TextView txtBirth;
    TextView txtTel;

    public SingleItemView(Context context) {
        this(context, null);
    }

    public SingleItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService((context.LAYOUT_INFLATER_SERVICE));

        layoutInflater.inflate(R.layout.single_item, this, true);

        txtName = findViewById(R.id.txtViewName);
        txtBirth = findViewById(R.id.txtViewBirth);
        txtTel = findViewById(R.id.txtViewTel);
    }

    public void SetTxtName(String name)
    {
        this.txtName.setText(name);
    }

    public void SetTxtBirth(String birth)
    {
        this.txtBirth.setText(birth);
    }

    public void SetTxtTel(String tel)
    {
        this.txtTel.setText(tel);
    }
}
