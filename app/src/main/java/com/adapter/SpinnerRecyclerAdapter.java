package com.adapter;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.model.LocationData;
import com.sunilnawale.testassignment.R;

import java.util.ArrayList;

public class SpinnerRecyclerAdapter extends BaseAdapter {
    private ArrayList<LocationData> itemList;

    public SpinnerRecyclerAdapter(ArrayList<LocationData> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        if(itemView==null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_spinner_item, parent, false);
        }
        TextView txt_location = (TextView) itemView.findViewById(R.id.txt_location);
        txt_location.setText(itemList.get(position).getName());
        return itemView;
    }

}
