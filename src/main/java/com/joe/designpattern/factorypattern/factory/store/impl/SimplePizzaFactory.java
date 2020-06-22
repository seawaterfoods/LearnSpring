package com.joe.designpattern.factorypattern.factory.store.impl;

import com.joe.designpattern.factorypattern.factory.pizza.impl.simple.CheesePizza;
import com.joe.designpattern.factorypattern.factory.pizza.Pizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.simple.ClamPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.simple.GreekPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.simple.PepperomiPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.simple.VeggiePizza;

public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;


        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else if (type.equals("greek")){
            pizza = new GreekPizza();
        }else if (type.equals("pepperomi")){
            pizza = new PepperomiPizza();
        }else if (type.equals("clam")){
            pizza = new ClamPizza();
        }else if (type.equals("veggie")){
            pizza = new VeggiePizza();
        }

        return pizza;

    }

}
