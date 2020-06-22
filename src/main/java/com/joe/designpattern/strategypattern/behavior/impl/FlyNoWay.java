package com.joe.designpattern.strategypattern.behavior.impl;

import com.joe.designpattern.strategypattern.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}
