package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.command.Command;

public class MacroCommad implements Command {
    private Command[] commands;

    public MacroCommad (Command[] commands){
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0;i<commands.length;i++){
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0;i<commands.length;i++){
            commands[i].undo();
        }

    }
}
