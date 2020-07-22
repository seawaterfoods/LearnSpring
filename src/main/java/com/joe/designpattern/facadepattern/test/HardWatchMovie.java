package com.joe.designpattern.facadepattern.test;

import com.joe.designpattern.facadepattern.hometheater.*;

public class HardWatchMovie {
    public static void main(String[] args) {
        Amplifier amplifier=new Amplifier("");
        DvdPlayer dvdPlayer=new DvdPlayer("",amplifier);
        PopcornPopper popcornPopper=new PopcornPopper("");
        TheaterLights lights=new TheaterLights("");
        Screen screen = new Screen("");
        Projector projector = new Projector("",dvdPlayer);


        popcornPopper.on();
        popcornPopper.off();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        amplifier.on();
        amplifier.setDvd(dvdPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);

        dvdPlayer.on();
        dvdPlayer.play("AV");

    }
}
