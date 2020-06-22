package com.joe.designpattern.factorypattern.factory.store.impl;

import com.joe.designpattern.factorypattern.factory.Ingredient.PizzaIngredientFactory;
import com.joe.designpattern.factorypattern.factory.Ingredient.impl.NYPizzaIngredientFactory;
import com.joe.designpattern.factorypattern.factory.pizza.Pizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.CheesePizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.newyork.NYStyleCheesePizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.newyork.NYStyleClamPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.newyork.NYStylePepperoniPizza;
import com.joe.designpattern.factorypattern.factory.pizza.impl.newyork.NYStyleVeggiePizza;
import com.joe.designpattern.factorypattern.factory.store.PizzaStore;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String item) {
        Pizza pizza=null;
        PizzaIngredientFactory ingredientFactory=new NYPizzaIngredientFactory();

        if (item.equals("cheese")){
//            pizza = new CheesePizza(ingredientFactory);
//            pizza.setName("New York Style Cheese Pizza");
            return new NYStyleCheesePizza();
        }else if (item.equals("veggie")){
            return new NYStyleVeggiePizza();
        }else if (item.equals("clam")){
            return new NYStyleClamPizza();
        }else if (item.equals("pepperoni")){
            return new NYStylePepperoniPizza();
        }
        else return null;
//        return pizza;
    }
}
