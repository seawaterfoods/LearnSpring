package com.joe.designpattern.factorypattern.factory.pizza.impl.chicago;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;

import java.util.ArrayList;

public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza(){

        name = "Chicago Style Sauce and Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Chicago Veggie");
    }
}
