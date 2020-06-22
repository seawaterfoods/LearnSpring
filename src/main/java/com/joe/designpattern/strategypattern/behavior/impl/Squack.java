package com.joe.designpattern.strategypattern.behavior.impl;

import com.joe.designpattern.strategypattern.behavior.QuackBehavior;

public class Squack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squack!!");
    }
}
