package com.joe.designpattern.adapterpattern.Ducks;

public class MallardDuck implements Duck{

    protected int distance = 5;

    @Override
    public void quack() {
        System.out.println("Quack!");
    }

    @Override
    public void fly() {
        System.out.println("飛行"+distance+"公尺。");
    }
}
