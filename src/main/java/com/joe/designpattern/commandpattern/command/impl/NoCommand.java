package com.joe.designpattern.commandpattern.command.impl;

import com.joe.designpattern.commandpattern.command.Command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("這是空的。");
    }

    @Override
    public void undo() {
        System.out.println("這是空的。");
    }
}
