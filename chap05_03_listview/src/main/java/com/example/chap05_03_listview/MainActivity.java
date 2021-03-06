package com.example.chap05_03_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtAddName;
    ListView listView;
    SingerAdapter singerAdapter;
    int no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAddName = findViewById(R.id.txtAddName);

        listView = findViewById(R.id.listView);

        singerAdapter = new SingerAdapter();

        singerAdapter.addItem(new SingerItem("소녀시대", "010-1234-5678", ++no, R.drawable.singer1));
        singerAdapter.addItem(new SingerItem("걸스데이", "010-1234-5678", ++no, R.drawable.singer2));
        singerAdapter.addItem(new SingerItem("여자친구", "010-1234-5678", ++no, R.drawable.singer3));
        singerAdapter.addItem(new SingerItem("티아라", "010-1234-5678", ++no, R.drawable.singer4));
        singerAdapter.addItem(new SingerItem("AOA", "010-1234-5678", ++no, R.drawable.singer5));

        listView.setAdapter(singerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem)singerAdapter.getItem(position);
                txtAddName.setText(item.getName());
            }
        });

        final Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singerAdapter.addItem(new SingerItem(txtAddName.getText().toString(), "010-1234-5678", ++no, R.drawable.singer1));
                singerAdapter.notifyDataSetChanged();
            }
        });

    }

    public class SingerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void  addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //# 음... 이걸 어찌설명하지.........
            if ( convertView == null) {
                convertView = new SingerItemView(MainActivity.this);
                SingerItem item = items.get(position);
                ((SingerItemView)convertView).setTxtName(item.getName());
                ((SingerItemView)convertView).setTxtPhoneNum(item.getPhonNum());
                ((SingerItemView)convertView).setTxtNo(item.getNo());
                ((SingerItemView)convertView).setImageView(item.getResId());

            }else{
                SingerItem item = items.get(position);
                ((SingerItemView)convertView).setTxtName(item.getName());
                ((SingerItemView)convertView).setTxtPhoneNum(item.getPhonNum());
                ((SingerItemView)convertView).setTxtNo(item.getNo());
                ((SingerItemView)convertView).setImageView(item.getResId());
            }


//            SingerItemView view = new SingerItemView(MainActivity.this);
//            SingerItem item = items.get(position);
//            view.setTxtName(item.getName());
//            view.setTxtPhoneNum(item.getPhonNum());
//            view.setTxtNo(item.getNo());
//            view.setImageView(item.getResId());

            return convertView;
        }
    }
}
