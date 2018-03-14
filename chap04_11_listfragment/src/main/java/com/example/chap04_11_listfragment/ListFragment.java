package com.example.chap04_11_listfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by BK on 2018-03-14.
 */

public class ListFragment extends Fragment {
    String[] values  = {"1번 이미지"
                        ,"2번 이미지"
                        ,"3번 이미지"
                        ,"4번 이미지"
                        ,"5번 이미지"};

    public static interface ImageSelectionCallback{
        public  void onImageSelected(int position);
    }

    public  ImageSelectionCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = rootView.findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, values);

        listView.setAdapter(arrayAdapter);;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(callback != null){
                    callback.onImageSelected(position);
                }
            }
        });

        //return super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
}
