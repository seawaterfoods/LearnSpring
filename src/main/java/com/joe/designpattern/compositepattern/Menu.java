package com.joe.designpattern.compositepattern;


import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    //    menu可以有任意數目的子類別，這些仔類別都必須屬於MenuComponent類型，我們使用內部的ArrayList紀錄
    private ArrayList menuComponents = new ArrayList();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //    在這裡可以將菜單項目和其他菜單加入菜單中，因為菜單跟菜單項目都是MenuComponent,
//    所以我們只需要用一個方法即可兩者兼顧。
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent) menuComponents.get(i);
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(",  " + getDescription());
        System.out.println("--------------------");
//            在這裡用Iterator遍歷所有的menuComponent，因為所有menu跟menuItem都有print()，所以只需要調用print()即可。
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
    @Override
    public Iterator createIterator(){
        return new CompositeIterator(menuComponents.iterator());
    }

}
