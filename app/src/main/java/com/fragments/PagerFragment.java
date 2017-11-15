package com.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunilnawale.testassignment.R;
import com.sunilnawale.testassignment.databinding.FragmentPagerBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends BaseFragment {

    String fragmentName;

    public PagerFragment() {
        // Required empty public constructor
    }

    public static PagerFragment newInstance(String fragmentName) {
        PagerFragment frag = new PagerFragment();
        Bundle args = new Bundle();
        args.putString("fragmentName", fragmentName);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        fragmentName = args.getString("fragmentName", "Fragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPagerBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pager, container, false);
        binding.txtFrag.setText(fragmentName);
        binding.txtFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(getActivity(), fragmentName);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }
}
