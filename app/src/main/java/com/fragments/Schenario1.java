package com.fragments;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adapter.RecyclerItemAdapter;
import com.adapter.SectionPagerAdapter;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.listeners.onItemClickedListener;
import com.model.Item;
import com.model.LocationData;
import com.sunilnawale.testassignment.R;
import com.sunilnawale.testassignment.databinding.FragmentScenario1Binding;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Schenario1 extends BaseFragment implements View.OnClickListener {
    FragmentScenario1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scenario1, container, false);

        //Point 1
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recyclerItems.setLayoutManager(layoutManager);
        try {
            InputStream inputStream = getActivity().getAssets().open("items.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            Type listType = new TypeToken<ArrayList<Item>>() {
            }.getType();
            ArrayList<Item> itemList = new GsonBuilder().create().fromJson(reader, listType);
            binding.recyclerItems.setAdapter(new RecyclerItemAdapter(itemList, listener));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Point 2
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addfragment(PagerFragment.newInstance("Fragment 1"), "Fragment1");
        adapter.addfragment(PagerFragment.newInstance("Fragment 2"), "Fragment2");
        adapter.addfragment(PagerFragment.newInstance("Fragment 3"), "Fragment3");
        adapter.addfragment(PagerFragment.newInstance("Fragment 4"), "Fragment4");
        binding.pagerFrag.setAdapter(adapter);

        //Point 5
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        return binding.getRoot();
    }


    onItemClickedListener listener = new onItemClickedListener() {
        @Override
        public void getSelectedItem(String item) {
            //Point 4
            binding.txtSection4.setText(item);
        }

        @Override
        public void getSelectedLocationDetails(LocationData location) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                binding.layoutColorBtns.setBackgroundColor(Color.RED);
                break;
            case R.id.btn2:
                binding.layoutColorBtns.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btn3:
                binding.layoutColorBtns.setBackgroundColor(Color.GREEN);
                break;
            default:
                binding.layoutColorBtns.setBackgroundColor(Color.WHITE);
        }
    }
}
