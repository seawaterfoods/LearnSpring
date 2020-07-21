package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.items.CeilingFan;

public class CeilingFanLowCommand extends CeilingFanCommand{

    public CeilingFanLowCommand(CeilingFan ceilingFan){
        this.ceilingFan=ceilingFan;
    }

    @Override
    public void execute(){
        super.execute();
        ceilingFan.low();
    }
}
