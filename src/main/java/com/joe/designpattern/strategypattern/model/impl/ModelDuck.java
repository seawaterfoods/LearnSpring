package com.joe.designpattern.strategypattern.model.impl;

import com.joe.designpattern.strategypattern.behavior.impl.FlyNoWay;
import com.joe.designpattern.strategypattern.behavior.impl.Quack;
import com.joe.designpattern.strategypattern.model.Duck;

public class ModelDuck extends Duck {
    public ModelDuck(){
        flyBehavior =new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("這是一隻模型鴨。");
    }
}
