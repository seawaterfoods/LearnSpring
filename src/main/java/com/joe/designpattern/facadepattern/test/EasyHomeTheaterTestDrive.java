package com.joe.designpattern.facadepattern.test;

import com.joe.designpattern.facadepattern.Facade.HomeTheaterFacade;

public class EasyHomeTheaterTestDrive {


    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade=new HomeTheaterFacade();
        homeTheaterFacade.watchMovie("Raiders of the Lost Ark");
        homeTheaterFacade.endMovie();
    }
}
