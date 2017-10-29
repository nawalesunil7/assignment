package com.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.roshanitejas.testassignment.utils;
import com.sunilnawale.testassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment1 extends Fragment {


    public PagerFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag1=inflater.inflate(R.layout.fragment_pager_fragment1, container, false);
        TextView txt_frag=(TextView)frag1.findViewById(R.id.txt_frag);
        txt_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.showToast(getActivity(),"Fragment 1");
            }
        });
        return frag1;
    }

}
