package com.joe.designpattern.factorypattern.factory.pizza.impl.newyork;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;

import java.util.ArrayList;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza(){

         name = "NY Style Sauce and Pepperoni Pizza";
         dough = "Thin Crust Dough";
         sauce = "Marinara Sauce";

        toppings.add("Grated Pepperoni");
    }
}
