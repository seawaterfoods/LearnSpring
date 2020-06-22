package com.joe.designpattern.factorypattern.factory.store.impl;

import com.joe.designpattern.factorypattern.factory.pizza.Pizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.chicago.ChicagoStyleCheesePizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.chicago.ChicagoStyleClamPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.chicago.ChicagoStylePepperoniPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.chicago.ChicagoStyleVeggiePizza;
import com.joe.designpattern.factorypattern.factory.store.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String item) {
        if (item.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }else if (item.equals("veggie")){
            return new ChicagoStyleVeggiePizza();
        }else if (item.equals("clam")){
            return new ChicagoStyleClamPizza();
        }else if (item.equals("pepperoni")){
            return new ChicagoStylePepperoniPizza();
        }else return null;
    }
}
