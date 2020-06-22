package com.joe.designpattern.factorypattern.test;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;
import com.joe.designpattern.factorypattern.factory.store.PizzaStore;
import com.joe.designpattern.factorypattern.factory.store.impl.ChicagoPizzaStore;
import com.joe.designpattern.factorypattern.factory.store.impl.NYPizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore =new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a "+ pizza.getName()+"\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName()+"\n");
    }
}
