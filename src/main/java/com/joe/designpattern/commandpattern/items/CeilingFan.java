package com.joe.designpattern.commandpattern.items;

public class CeilingFan {
    public static final int HIGH=3;
    public static final int MEDIUM=2;
    public static final int LOW=1;
    public static final int OFF=0;
    private String location;
    private int speed;

    public CeilingFan(String location){
        this.location = location;
        speed = OFF;
    }

    public void high(){
        speed=HIGH;
        System.out.println("設置"+location+"的風扇高轉速");
    }
    public void medium(){
        speed=MEDIUM;
        System.out.println("設置"+location+"的風扇中轉速");
    }
    public void low(){
        speed=LOW;
        System.out.println("設置"+location+"的風扇低轉速");
    }
    public void off(){
        speed=OFF;
        System.out.println("關掉"+location+"風扇");
    }

    public int getSpeed() {
        return speed;
    }
}
