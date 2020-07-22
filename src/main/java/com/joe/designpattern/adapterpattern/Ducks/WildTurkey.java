package com.joe.designpattern.adapterpattern.Ducks;

public class WildTurkey implements Turkey{

    private int distance = 1;

    @Override
    public void qobble() {
        System.out.println("Gobble gobble!!");
    }

    @Override
    public void fly() {

        System.out.println("飛行"+distance+"公尺。");
    }
}
