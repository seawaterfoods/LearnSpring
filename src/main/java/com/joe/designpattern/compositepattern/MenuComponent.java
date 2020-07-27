package com.joe.designpattern.compositepattern;

import java.util.Iterator;

public abstract class MenuComponent {

//    這裡把Composite方法組織在一起，為'新增','刪除'和'取得菜單'組件
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

//    這些是'操作'方法,他們被菜單項目所使用，其中一些也可用在菜單上。
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public String getDescription(){
        throw new UnsupportedOperationException();
    }
    public double getPrice(){
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }
//    'print'這個操作方法會同時被菜單及菜單項目所實現，不過還是在這裡先定義這個方法
    public void print(){
        throw new UnsupportedOperationException();
    }


    public Iterator createIterator(){
        throw new UnsupportedOperationException();
    }
}
