package com.joe.designpattern.factorypattern.factory.pizza.impl.chicago;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;

import java.util.ArrayList;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza(){
        name = "Chicago Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Chicago Reggiano Cheese");
    }
}
