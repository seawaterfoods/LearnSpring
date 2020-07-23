package com.joe.designpattern.templatemethodpattern.barista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tea extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("用熱水沖泡茶。");
    }

    @Override
    public void addCondiments() {
        System.out.println("加入檸檬。");
    }


    @Override
    protected boolean customerWantsCondiments() {
        String answer = getUserInput();

        if(answer.toLowerCase().startsWith("y")) {
            return true;
        }else {
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;

        System.out.println("你是否想要加檸檬在你的茶中？y/n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer=in.readLine();
        }catch (IOException ioe){
            return "no";
        }
        return answer;
    }
}
