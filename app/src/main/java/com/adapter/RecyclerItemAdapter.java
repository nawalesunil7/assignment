package com.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.listeners.onItemClickedListener;
import com.sunilnawale.testassignment.R;

import java.util.ArrayList;


public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerItemAdapter.ItemHolder> {
    ArrayList<String> itemList;
    onItemClickedListener listener;

    public RecyclerItemAdapter(ArrayList<String> itemList, onItemClickedListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView recycler_item;

        public ItemHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            recycler_item = (TextView) itemView.findViewById(R.id.recycler_item);
        }

        public void bindView(final String item) {
            recycler_item.setText(item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.getSelectedItem(item);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bindView(itemList.get(position));
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_item, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
