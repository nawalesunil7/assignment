package com.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adapter.RecyclerItemAdapter;
import com.adapter.SectionPagerAdapter;
import com.listeners.onItemClickedListener;
import com.model.LocationData;
import com.sunilnawale.testassignment.R;

import java.util.ArrayList;

public class Schenario1 extends Fragment implements View.OnClickListener {
    View v_scenario1 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v_scenario1 = inflater.inflate(R.layout.fragment_scenario1, container, false);

        //Point 1
        RecyclerView recycler_items = (RecyclerView) v_scenario1.findViewById(R.id.recycler_items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_items.setLayoutManager(layoutManager);
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("item 1");
        itemList.add("item 2");
        itemList.add("item 3");
        itemList.add("item 4");
        itemList.add("item 5");
        recycler_items.setAdapter(new RecyclerItemAdapter(itemList, listener));

        //Point 3
        ViewPager pager_frag = (ViewPager) v_scenario1.findViewById(R.id.pager_frag);
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addfragment(new PagerFragment1(), "Fragment1");
        adapter.addfragment(new PagerFragment2(), "Fragment2");
        adapter.addfragment(new PagerFragment3(), "Fragment3");
        adapter.addfragment(new PagerFragment4(), "Fragment4");
        pager_frag.setAdapter(adapter);

        //Point 5
        (v_scenario1.findViewById(R.id.btn1)).setOnClickListener(this);
        (v_scenario1.findViewById(R.id.btn2)).setOnClickListener(this);
        (v_scenario1.findViewById(R.id.btn3)).setOnClickListener(this);
        return v_scenario1;
    }


    onItemClickedListener listener = new onItemClickedListener() {
        @Override
        public void getSelectedItem(String item) {
            //Point 4
            TextView txt_section4 = (TextView) v_scenario1.findViewById(R.id.txt_section4);
            txt_section4.setText(item);
        }

        @Override
        public void getSelectedLocationDetails(LocationData location) {

        }
    };

    @Override
    public void onClick(View v) {
        LinearLayout layout_colorBtns = (LinearLayout) v_scenario1.findViewById(R.id.layout_colorBtns);
        switch (v.getId()) {
            case R.id.btn1:
                layout_colorBtns.setBackgroundColor(Color.RED);
                break;
            case R.id.btn2:
                layout_colorBtns.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btn3:
                layout_colorBtns.setBackgroundColor(Color.GREEN);
                break;
            default:
                layout_colorBtns.setBackgroundColor(Color.WHITE);
        }
    }
}
