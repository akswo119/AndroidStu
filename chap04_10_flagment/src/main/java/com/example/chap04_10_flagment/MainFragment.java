package com.example.chap04_10_flagment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by BK on 2018-03-13.
 */

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main, container, false);

        Button btn = rootView.findViewById(R.id.btnMenu);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               gogo();
            }
        });

        return rootView;
    }

    private  void gogo(){
        MainActivity activity = (MainActivity)getActivity();
        activity.onFragmentChanged(1);
    }

}
