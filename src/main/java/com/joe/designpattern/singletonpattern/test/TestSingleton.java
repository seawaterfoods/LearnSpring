package com.joe.designpattern.singletonpattern.test;

import com.joe.designpattern.singletonpattern.ChocolateBoiler;
import com.joe.designpattern.singletonpattern.EnumChocolateBoiler;

public class TestSingleton {


    public static void main(String[] args) {
        System.out.println("Start Singleton!");
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        System.out.println("Begin: "+chocolateBoiler);
        chocolateBoiler.fill();
        System.out.println("fill: "+chocolateBoiler);
        chocolateBoiler.boil();
        System.out.println("boil: "+chocolateBoiler);
        chocolateBoiler.drain();
        System.out.println("drain: "+chocolateBoiler+"\n");

        EnumChocolateBoiler enumChocolateBoiler =EnumChocolateBoiler.INSTANCE;
        System.out.println("Begin Enum: "+enumChocolateBoiler);
        enumChocolateBoiler.fill();
        System.out.println("fill Enum: "+enumChocolateBoiler);
        enumChocolateBoiler.boil();
        System.out.println("boil Enum: "+enumChocolateBoiler);
        enumChocolateBoiler.drain();
        System.out.println("drain Enum: "+enumChocolateBoiler+"\n");

    }
}
