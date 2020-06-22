package com.joe.designpattern.factorypattern.factory.pizza.impl.chicago;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;

import java.util.ArrayList;

public class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza(){

        name = "Chicago Style Sauce and Clam Pizza";
        dough = "Thin Crust Dough Clam";
        sauce = "Marinara Clam Sauce";

        toppings.add("Grated Chicago Clam");

    }
}
