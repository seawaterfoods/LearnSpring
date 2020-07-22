package com.joe.designpattern.adapterpattern.Ducks;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck =new MallardDuck();
        Turkey DuckAdapter = new DuckAdapter(duck);

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("火雞做出...");
        testTurkey(turkey);

        System.out.println("\n 鴨子做出...");
        testDuck(duck);

        System.out.println("\n 披著鴨子皮的火雞做出...");
        testDuck(turkeyAdapter);

        System.out.println("\n 披著火雞皮的鴨子做出...");
        testTurkey(DuckAdapter);
    }

    private static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
    private static void testTurkey(Turkey turkey){
        turkey.qobble();
        turkey.fly();
    }
}
