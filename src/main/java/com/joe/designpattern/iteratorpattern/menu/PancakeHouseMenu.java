package com.joe.designpattern.iteratorpattern.menu;

import com.joe.designpattern.iteratorpattern.item.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
    private ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList();
        addItem("K&B 煎餅早餐","蛋,新鮮蔬菜跟吐司",true,2.99);
        addItem("Regular 煎餅早餐","蛋跟香腸",false,2.99);
        addItem("藍莓煎餅","新鮮藍莓與藍莓糖漿與薄煎餅",true,3.49);
        addItem("鬆餅","鬆餅，可選草莓或藍莓",true,3.59);


    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem =new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator(){
        return menuItems.iterator();
    }

}
