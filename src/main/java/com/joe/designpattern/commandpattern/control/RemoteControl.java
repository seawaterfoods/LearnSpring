package com.joe.designpattern.commandpattern.control;

import com.joe.designpattern.commandpattern.command.Command;
import com.joe.designpattern.commandpattern.command.impl.NoCommand;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0 ;i<7;i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot]=onCommand;
        offCommands[slot]=offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n======= Remote Control =======\n");
        for (int i = 0; i<onCommands.length;i++){
            stringBuffer.append("[slot "+i+"]"+onCommands[i].getClass().getSimpleName()+ "        "+offCommands[i].getClass().getSimpleName()+"\n");
        }

        return stringBuffer.toString();
    }
}
