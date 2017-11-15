package com.model;

import java.io.Serializable;

public class Item implements Serializable {
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    String itemname;
}
