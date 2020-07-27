package com.joe.designpattern.iteratorpattern.test;

import com.joe.designpattern.iteratorpattern.Waitress;
import com.joe.designpattern.iteratorpattern.menu.CafeMenu;
import com.joe.designpattern.iteratorpattern.menu.DinerMenu;
import com.joe.designpattern.iteratorpattern.menu.Menu;
import com.joe.designpattern.iteratorpattern.menu.PancakeHouseMenu;

public class MenuTestDrive {
    public static void main(String[] args) {
        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu,cafeMenu);

        waitress.printMenu();
    }
}
