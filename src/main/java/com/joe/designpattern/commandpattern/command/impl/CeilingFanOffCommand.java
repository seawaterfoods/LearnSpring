package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.items.CeilingFan;

public class CeilingFanOffCommand extends CeilingFanCommand{

    public CeilingFanOffCommand(CeilingFan ceilingFan){
        this.ceilingFan=ceilingFan;
    }

    @Override
    public void execute(){
        super.execute();
        ceilingFan.off();
    }
}
