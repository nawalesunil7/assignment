package com.listeners;


import com.model.LocationData;

public interface onItemClickedListener {
    public void getSelectedItem(String item);
    public void getSelectedLocationDetails(LocationData location);
}
