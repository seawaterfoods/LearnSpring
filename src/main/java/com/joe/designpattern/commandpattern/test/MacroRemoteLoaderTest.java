package com.joe.designpattern.commandpattern.test;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.command.impl.*;
import com.joe.designpattern.commandpattern.control.RemoteControlWithUndo;
import com.joe.designpattern.commandpattern.items.CeilingFan;
import com.joe.designpattern.commandpattern.items.GarageDoor;
import com.joe.designpattern.commandpattern.items.Light;
import com.joe.designpattern.commandpattern.items.Stereo;

public class MacroRemoteLoaderTest {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl= new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        Light livingRoomLight = new Light("Living Room");
        Light kitchenRoomLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor();
        Stereo livingRoomStereo = new Stereo("Living Room");

        LightCommand livingRoomLightSwitch = new LightCommand(livingRoomLight);
        LightCommand kitchenRoomLightSwitch = new LightCommand(kitchenRoomLight);
        GarageDoorCommand garageDoorCommand = new GarageDoorCommand(garageDoor);
        StereoOnWithCDCommand livingRoomStereoOn = new StereoOnWithCDCommand(livingRoomStereo);
        StereoOffWithCDCommand livingRoomStereoOff = new StereoOffWithCDCommand(livingRoomStereo);

        Command[] partyOn = {livingRoomLightSwitch,kitchenRoomLightSwitch,garageDoorCommand,livingRoomStereoOn,ceilingFanHigh};
        Command[] partyOff = {livingRoomLightSwitch,kitchenRoomLightSwitch,garageDoorCommand,livingRoomStereoOff,ceilingFanOff};

        MacroCommad macroOn = new MacroCommad(partyOn);
        MacroCommad macroOff = new MacroCommad(partyOff);

        remoteControl.setCommand(0,ceilingFanMedium,ceilingFanOff);
        remoteControl.setCommand(1,ceilingFanHigh,ceilingFanOff);
        remoteControl.setCommand(2,macroOn,macroOff);


        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        System.out.println("====macro test====");
        remoteControl.onButtonWasPushed(2);
        System.out.println("--------------party over----------------");
        remoteControl.undoButtonWasPushed();
    }
}
