package com.joe.designpattern.commandpattern.items;

public class GarageDoor {
    private boolean GD;

    private void up(){
        System.out.println("'喀喀喀'車庫門拉上去了!");
    }
    private void down(){
        System.out.println("'喀喀喀'車庫鐵門拉下來了!");
    }

    private void stop(){
        System.out.println("'喀答'車庫門停了!\n");
    }

    private void lightOn(){
        System.out.println("登!車庫燈亮了!");
    }

    private void lightOff(){
        System.out.println("登!車庫燈關了!");
    }
    public void garageDoorSwitch(){
        if (!GD){
            GD=true;
            up();
            lightOn();
            stop();
        }else {
            GD=false;
            down();
            lightOff();
            stop();
        }
    }
    public void forciblyOff(){
        if (!GD){
            System.out.println("已經全關了。\n");
        }else {
            GD=false;
            down();
            lightOff();
            stop();
        }
    }
}
