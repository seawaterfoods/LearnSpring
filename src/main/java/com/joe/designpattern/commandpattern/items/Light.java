package com.joe.designpattern.commandpattern.items;

public class Light {

    private boolean button;
    private String location;

    public Light(String location) {
        this.location=location;
    }

    public Light() {

    }

    public void LightSwitch() {

        if (!button) {
            button=true;
            System.out.println("打開"+location+"燈。\n");
        } else {
            button=false;
            System.out.println("關"+location+"燈。\n");
        }
    }
    public void forciblyOff(){
        if (!button){
            System.out.println("已經關了。\n");
        }else {
            button=false;
            System.out.println("關"+location+"燈。\n");
        }
    }

}
