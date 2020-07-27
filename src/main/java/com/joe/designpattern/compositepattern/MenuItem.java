package com.joe.designpattern.compositepattern;

import java.util.Iterator;

public class MenuItem extends MenuComponent{
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void print(){
        System.out.print("  "+getName());
        if (isVegetarian()){
            System.out.print("(v)");
        }
        System.out.print(",  "+getPrice());
        System.out.println("     -- "+getDescription());
    }

    @Override
    public Iterator createIterator(){
        return new NullIterator();
    }
}
