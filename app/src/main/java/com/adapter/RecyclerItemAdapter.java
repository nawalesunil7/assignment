package com.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.listeners.onItemClickedListener;
import com.model.Item;
import com.viewmodel.ItemModel;
import com.sunilnawale.testassignment.R;
import com.sunilnawale.testassignment.databinding.LayoutItemsBinding;

import java.util.ArrayList;


public class RecyclerItemAdapter extends RecyclerView.Adapter<RecyclerItemAdapter.ItemHolder> {
    ArrayList<Item> itemList;
    onItemClickedListener listener;

    public RecyclerItemAdapter(ArrayList<Item> itemList, onItemClickedListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        LayoutItemsBinding binding;

        public ItemHolder(LayoutItemsBinding binding) {
            super(binding.recyclerItem);
            this.binding = binding;
        }
    }

    @Override
    public void onBindViewHolder(ItemHolder holder,final int position) {
        holder.binding.setItm(new ItemModel(itemList.get(position)));
        holder.binding.recyclerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.getSelectedItem(itemList.get(position).getItemname());
            }
        });
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_items, parent, false);
        return new ItemHolder(binding);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
