package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.items.CeilingFan;

public class CeilingFanHighCommand extends CeilingFanCommand{

    public CeilingFanHighCommand(CeilingFan ceilingFan){
        this.ceilingFan=ceilingFan;
    }

    @Override
    public void execute(){
        super.execute();
        ceilingFan.high();
    }
}