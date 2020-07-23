package com.joe.designpattern.templatemethodpattern.test;

import com.joe.designpattern.templatemethodpattern.sort.Duck;

import java.util.Arrays;

public class DuckSortTestDrive {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("Daffy",8),
                new Duck("Dewey",2),
                new Duck("Howard",7),
                new Duck("Joy",2),
                new Duck("Joe",10),
                new Duck("Eder",2),
                new Duck("Mark",3),
        };

        System.out.println("在排序之前：");
        System.out.println(Arrays.toString(ducks));

        Arrays.sort(ducks);

        System.out.println("在排序之後：");
        System.out.println(Arrays.toString(ducks));

    }

}
