package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.items.Light;

public class LightCommand implements Command {
    public Light light;

    public LightCommand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.LightSwitch();
    }

    @Override
    public void undo() {
        light.forciblyOff();
    }
}
