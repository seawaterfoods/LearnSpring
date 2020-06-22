package com.joe.designpattern.factorypattern.factory.pizza.impl.chicago;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;

import java.util.ArrayList;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza(){
        name = "Chicago Style Sauce and Pepperoni Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Chicago Pepperoni");
    }
}
