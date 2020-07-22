package com.joe.designpattern.adapterpattern.Ducks;

public class DuckAdapter implements Turkey{
    private Duck duck;


    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void qobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
        System.out.println("又飛回4公尺");
    }
}
