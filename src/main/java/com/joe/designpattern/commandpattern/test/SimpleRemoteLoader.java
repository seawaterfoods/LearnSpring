package com.joe.designpattern.commandpattern.test;

import com.joe.designpattern.commandpattern.command.impl.LightCommand;
import com.joe.designpattern.commandpattern.control.SimpleRemoteControl;
import com.joe.designpattern.commandpattern.command.impl.GarageDoorCommand;
import com.joe.designpattern.commandpattern.items.GarageDoor;
import com.joe.designpattern.commandpattern.items.Light;

public class SimpleRemoteLoader {
    public static void main(String[] args) {
        SimpleRemoteControl remote= new SimpleRemoteControl();
        Light light=new Light();
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorCommand garageDoorCommand = new GarageDoorCommand(garageDoor);
        LightCommand lightCommand = new LightCommand(light);

        remote.setCommand(lightCommand);
        remote.buttonWasPressed();
        remote.buttonWasPressed();

        remote.setCommand(garageDoorCommand);
        remote.buttonWasPressed();
        remote.buttonWasPressed();
    }
}
