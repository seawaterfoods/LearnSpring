package com.joe.designpattern.templatemethodpattern.sort;

public class Duck implements Comparable{

    protected String name;
    protected int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Duck otherDuck = (Duck)o;

//        我們在這邊指定鴨子是如何比較，如果這隻鴨子比其他鴨子重就返回1，
//        如果一樣重就返回0，如果較輕就返回-1。
        if (this.weight<otherDuck.weight){
            return -1;
        }else if (this.weight == otherDuck.weight){
            return 0;
        }else {
            return 1;
        }
    }
}
