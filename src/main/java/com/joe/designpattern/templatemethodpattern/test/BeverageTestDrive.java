package com.joe.designpattern.templatemethodpattern.test;

import com.joe.designpattern.templatemethodpattern.barista.Coffee;
import com.joe.designpattern.templatemethodpattern.barista.Tea;

public class BeverageTestDrive {
    public static void main(String[] args) {

        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

    }
}
