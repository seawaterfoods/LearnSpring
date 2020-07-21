package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.items.CeilingFan;

public class CeilingFanMediumCommand extends CeilingFanCommand{

    public CeilingFanMediumCommand(CeilingFan ceilingFan){
        this.ceilingFan=ceilingFan;
    }

    @Override
    public void execute(){
        super.execute();
        ceilingFan.medium();
    }
}