package com.joe.designpattern.facadepattern.Facade;

import com.joe.designpattern.facadepattern.hometheater.*;

public class HomeTheaterFacade {

        Amplifier amplifier=new Amplifier("擴音器");
        DvdPlayer dvdPlayer=new DvdPlayer("DVD撥放器",amplifier);
        PopcornPopper popcornPopper=new PopcornPopper("爆米花機");
        TheaterLights lights=new TheaterLights("劇院燈光");
        Screen screen = new Screen("屏幕");
        Projector projector = new Projector("投影機",dvdPlayer);


    public void watchMovie(String movie){
        System.out.println("準備看一場電影嚕~");
        popcornPopper.on();
        popcornPopper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setDvd(dvdPlayer);
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie(){
        System.out.println("電影結束放映嚕~");
        popcornPopper.off();
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();

    }
}
