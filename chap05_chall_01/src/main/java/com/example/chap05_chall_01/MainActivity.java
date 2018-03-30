package com.example.chap05_chall_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtBirth;
    EditText txtTel;
    ListView listView;

    TextView txtCnt;

    SingleAdapter singleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtBirth = findViewById(R.id.txtBirth);
        txtTel = findViewById(R.id.txtTel);

        txtCnt = findViewById(R.id.txtCnt);

        listView = findViewById(R.id.listView);
        singleAdapter = new SingleAdapter();

        listView.setAdapter(singleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingleItem item = (SingleItem)singleAdapter.getItem(position);

                txtName.setText(item.getName());
                txtBirth.setText(item.getBirth());
                txtTel.setText(item.getTel());
            }
        });

        final Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleAdapter.addItem(new SingleItem(txtName.getText().toString(), txtBirth.getText().toString(), txtTel.getText().toString()));
                singleAdapter.notifyDataSetChanged();

                txtCnt.setText( singleAdapter.getCount() + " 명");
            }
        });
    }

    public class SingleAdapter extends BaseAdapter {

        ArrayList<SingleItem> items = new ArrayList<SingleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void  addItem(SingleItem item){
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

            if (convertView == null){

                SingleItemView view = new SingleItemView(MainActivity.this);
                SingleItem item = items.get(position);
                view.SetTxtName(item.getName());
                view.SetTxtBirth(item.getBirth());
                view.SetTxtTel(item.getTel());
                return view;
            }else {
                SingleItemView view = (SingleItemView)convertView;
                SingleItem item = items.get(position);
                view.SetTxtName(item.getName());
                view.SetTxtBirth(item.getBirth());
                view.SetTxtTel(item.getTel());
                return view;
            }

        }
    }
}
