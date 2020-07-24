package com.joe.designpattern.iteratorpattern.menu;

import com.joe.designpattern.iteratorpattern.item.MenuItem;
import com.joe.designpattern.iteratorpattern.iterator.impl.DinerMenuIterator;

import java.util.Iterator;

public class DinerMenu implements Menu {
    public static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu(){
        menuItems=new MenuItem[MAX_ITEMS];

        addItem("素食BLT","素培根,生菜,番茄用軟皮麵包做",true,2.99);
        addItem("BLT","培根,生菜,番茄",false,2.99);
        addItem("例湯","一份例湯,配土豆沙拉",false,3.29);
        addItem("熱狗","熱狗,酸菜,上等起士",false,3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem =new MenuItem(name, description, vegetarian, price);
       if (numberOfItems>=MAX_ITEMS){
           System.out.println("抱歉菜單滿了，別再加任何新的菜單了!");
       }else {
           menuItems[numberOfItems]=menuItem;
           numberOfItems= numberOfItems+1;
       }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }

}
