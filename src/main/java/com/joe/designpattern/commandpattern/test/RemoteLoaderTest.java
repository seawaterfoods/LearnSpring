package com.joe.designpattern.commandpattern.test;

import com.joe.designpattern.commandpattern.command.impl.GarageDoorCommand;
import com.joe.designpattern.commandpattern.command.impl.LightCommand;
import com.joe.designpattern.commandpattern.command.impl.StereoOffWithCDCommand;
import com.joe.designpattern.commandpattern.command.impl.StereoOnWithCDCommand;
import com.joe.designpattern.commandpattern.control.RemoteControl;
import com.joe.designpattern.commandpattern.control.SimpleRemoteControl;
import com.joe.designpattern.commandpattern.items.GarageDoor;
import com.joe.designpattern.commandpattern.items.Light;
import com.joe.designpattern.commandpattern.items.Stereo;

public class RemoteLoaderTest {
    public static void main(String[] args) {
        RemoteControl remoteControl= new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenRoomLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor();
        Stereo livingRoomStereo = new Stereo("Living Room");

        LightCommand livingRoomLightSwitch = new LightCommand(livingRoomLight);
        LightCommand kitchenRoomLightSwitch = new LightCommand(kitchenRoomLight);
        GarageDoorCommand garageDoorCommand = new GarageDoorCommand(garageDoor);
        StereoOnWithCDCommand livingRoomStereoOn = new StereoOnWithCDCommand(livingRoomStereo);
        StereoOffWithCDCommand livingRoomStereoOff = new StereoOffWithCDCommand(livingRoomStereo);

        remoteControl.setCommand(0,livingRoomLightSwitch,livingRoomLightSwitch);
        remoteControl.setCommand(1,kitchenRoomLightSwitch,kitchenRoomLightSwitch);
        remoteControl.setCommand(2,garageDoorCommand,garageDoorCommand);
        remoteControl.setCommand(3,livingRoomStereoOn,livingRoomStereoOff);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}
