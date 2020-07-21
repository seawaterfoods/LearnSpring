package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.items.Stereo;

public class StereoOffWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo){
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
        System.out.println();
    }

    @Override
    public void undo() {
        stereo.off();
        System.out.println();
    }
}
