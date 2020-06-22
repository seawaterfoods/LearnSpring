package com.joe.designpattern.strategypattern.test;

import com.joe.designpattern.strategypattern.behavior.impl.FlyRocketPowered;
import com.joe.designpattern.strategypattern.model.Duck;
import com.joe.designpattern.strategypattern.model.impl.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck model = new ModelDuck();
        model.performQuack();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
        model.swim();
        model.display();
    }
}
