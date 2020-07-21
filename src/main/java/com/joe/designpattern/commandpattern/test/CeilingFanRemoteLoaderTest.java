package com.joe.designpattern.commandpattern.test;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.command.impl.*;
import com.joe.designpattern.commandpattern.control.RemoteControl;
import com.joe.designpattern.commandpattern.control.RemoteControlWithUndo;
import com.joe.designpattern.commandpattern.items.CeilingFan;
import com.joe.designpattern.commandpattern.items.GarageDoor;
import com.joe.designpattern.commandpattern.items.Light;
import com.joe.designpattern.commandpattern.items.Stereo;

public class CeilingFanRemoteLoaderTest {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl= new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0,ceilingFanMedium,ceilingFanOff);
        remoteControl.setCommand(1,ceilingFanHigh,ceilingFanOff);


        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
