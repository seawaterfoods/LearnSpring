package com.joe.designpattern.strategypattern.model;

import com.joe.designpattern.strategypattern.behavior.FlyBehavior;
import com.joe.designpattern.strategypattern.behavior.QuackBehavior;

public abstract class Duck {

    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public Duck(){}

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public abstract void display();

    public void swim(){
        System.out.println("所有鴨子都會漂浮在水上，誘餌鴨也不例外！");
    }
}
