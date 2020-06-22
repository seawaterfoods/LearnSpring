package com.joe.designpattern.strategypattern.model.impl;

import com.joe.designpattern.strategypattern.behavior.impl.FlyWithWings;
import com.joe.designpattern.strategypattern.behavior.impl.Quack;
import com.joe.designpattern.strategypattern.model.Duck;

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("我是真的綠頭鴨!");
    }
}
