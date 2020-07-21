package com.joe.designpattern.commandpattern.control;

import com.joe.designpattern.commandpattern.command.Command;

public class SimpleRemoteControl {
//    有一個插槽持有命令，而這個命令控制一個裝置。
    public Command slot;

    public SimpleRemoteControl(){}

//    這個方法設置插槽所控制的命令，
//    如果這段code的客戶想要多次改變遙控器按鈕的行為，可以多次掉用這個方法。
    public void setCommand(Command command){
        slot=command;
    }

//    當按下按鈕時，這個方法就會被調用，
//    使得當前此插槽所綁定的命令執行，並調用他的execute()方法
    public void buttonWasPressed(){
        slot.execute();
    }
}
