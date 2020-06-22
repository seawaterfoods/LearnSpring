package com.joe.designpattern.strategypattern.behavior.impl;

import com.joe.designpattern.strategypattern.behavior.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("火箭動力飛行!!");
    }
}
