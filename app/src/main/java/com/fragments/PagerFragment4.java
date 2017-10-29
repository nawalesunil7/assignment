package com.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roshanitejas.testassignment.utils;
import com.sunilnawale.testassignment.R;

public class PagerFragment4 extends Fragment {


    public PagerFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag4 = inflater.inflate(R.layout.fragment_pager_fragment4, container, false);
        TextView txt_frag = (TextView) frag4.findViewById(R.id.txt_frag);
        txt_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.showToast(getActivity(), "Fragment 4");
            }
        });
        return frag4;
    }

}
