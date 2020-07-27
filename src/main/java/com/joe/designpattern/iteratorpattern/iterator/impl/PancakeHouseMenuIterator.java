package com.joe.designpattern.iteratorpattern.iterator.impl;

import com.joe.designpattern.iteratorpattern.item.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

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

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("你沒辦法再刪除了!");
        }
        if (items.size()-1 !=0){
            for (int i = position-1; i <(items.size()-1);i++){
                items.set(i,items.get(i+1));
            }
            items.set(items.size()-1,null);
        }
    }
}
