package com.joe.designpattern.decoratorpattern.condiment;

import com.joe.designpattern.decoratorpattern.beverage.Beverage;

public class Milk extends CondimentDecorator{
    Beverage beverage;
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Milk";
    }

    @Override
    public double cost() {
        return 0.1+beverage.cost();
    }
}
