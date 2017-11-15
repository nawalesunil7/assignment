package com.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.model.Item;
import com.sunilnawale.testassignment.BR;

public class ItemModel extends BaseObservable {
    Item itm;

    public ItemModel(Item itm) {
        this.itm = itm;
    }

    @Bindable
    public String getItemname() {
        return itm.getItemname();
    }

    public void setItemname(String itemname) {
        itm.setItemname(itemname);
        notifyPropertyChanged(BR.itemname);
    }
}
