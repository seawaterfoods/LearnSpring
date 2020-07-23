package com.joe.designpattern.templatemethodpattern.barista;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    protected abstract void brew();

    public abstract void addCondiments();

    protected void boilWater() {
        System.out.println("用熱水沖泡茶。");
    }

    public void pourInCup() {
        System.out.println("煮好後倒入杯子。");
    }

//    建立一個Hook
    protected boolean customerWantsCondiments(){
        return true;
    }
}
