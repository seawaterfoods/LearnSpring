package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.items.GarageDoor;

public class GarageDoorCommand implements Command {

    public GarageDoor garageDoor;

    public GarageDoorCommand(GarageDoor garageDoor){
        this.garageDoor=garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.garageDoorSwitch();
    }

    @Override
    public void undo() {
        garageDoor.forciblyOff();
    }
}
