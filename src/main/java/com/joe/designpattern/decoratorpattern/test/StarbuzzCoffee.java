package com.joe.designpattern.decoratorpattern.test;

import com.joe.designpattern.decoratorpattern.beverage.Beverage;
import com.joe.designpattern.decoratorpattern.beverage.Decaf;
import com.joe.designpattern.decoratorpattern.beverage.Espresso;
import com.joe.designpattern.decoratorpattern.condiment.Milk;
import com.joe.designpattern.decoratorpattern.condiment.Mocha;
import com.joe.designpattern.decoratorpattern.condiment.Soy;
import com.joe.designpattern.decoratorpattern.condiment.Whip;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription()+" $"+beverage.cost());

        Beverage beverage1 =new Espresso();
        beverage1 =new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Milk(beverage1);
        beverage1 = new Soy(beverage1);
        System.out.println(beverage1.getDescription()+" $"+beverage1.cost());

        Beverage beverage2 = new Decaf();
        beverage2 = new Milk(beverage2);
        beverage2 = new Milk(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+" $"+beverage2.cost());

    }
}
