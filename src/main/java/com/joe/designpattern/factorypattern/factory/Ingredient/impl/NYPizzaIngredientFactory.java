package com.joe.designpattern.factorypattern.factory.Ingredient.impl;

import com.joe.designpattern.factorypattern.factory.Ingredient.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[]={new Garlic(),new Onion(),new Mushroom(),new Redpepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperomi();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
