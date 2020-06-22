package com.joe.designpattern.factorypattern.factory.pizza;

import com.joe.designpattern.factorypattern.factory.Ingredient.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    public String name;
//    public Dough dough;
    public String dough;
    public String sauce;
//    public Sauce sauce;
//    public Veggies veggies[];
//    public Cheese cheese;
//    public Clams clams;
    public ArrayList<String> toppings =new ArrayList<String>();

//    public abstract void prepare();
    public void prepare() {

        System.out.println("Preparing "+ name);
        System.out.println("Tossing dough..."+dough);
        System.out.println("Adding sauce..."+sauce);
        System.out.println("Adding toppings: ");
        for (int i = 0 ; i <toppings.size();i++){
            System.out.println("   "+ toppings.get(i));
        }
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        return display.toString();
    }
}
