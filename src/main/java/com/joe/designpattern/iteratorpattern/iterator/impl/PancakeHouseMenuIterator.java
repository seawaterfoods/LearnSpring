package com.joe.designpattern.iteratorpattern.iterator.impl;

import com.joe.designpattern.iteratorpattern.item.MenuItem;
import com.joe.designpattern.iteratorpattern.iterator.Iterator;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {

    private int position = 0;
    private ArrayList items;

    public PancakeHouseMenuIterator(ArrayList items) {
        this.items = items;
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) items.get(position);
        position++;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if(position>=items.size()|| items.get(position)==null){
            return false;
        }else {
            return true;
        }
    }
}
