package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.items.CeilingFan;

public class CeilingFanCommand implements Command {
    protected CeilingFan ceilingFan;
    protected int prevSpeed;

    @Override
    public void execute(){
        prevSpeed = ceilingFan.getSpeed();
    }

    @Override
    public void undo(){
        if (prevSpeed==CeilingFan.HIGH){
            ceilingFan.high();
        }else if (prevSpeed==CeilingFan.MEDIUM){
            ceilingFan.medium();
        }else if (prevSpeed==CeilingFan.LOW){
            ceilingFan.low();
        }else if (prevSpeed==CeilingFan.OFF){
            ceilingFan.off();
        }
    }
}
