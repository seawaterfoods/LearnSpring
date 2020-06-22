package com.joe.designpattern.factorypattern.factory.pizza.impl.newyork;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;

import java.util.ArrayList;

public class NYStyleClamPizza extends Pizza {

    public NYStyleClamPizza(){

         name = "NY Style Sauce and Cheese Pizza";
         dough = "Thin Crust Dough";
         sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
