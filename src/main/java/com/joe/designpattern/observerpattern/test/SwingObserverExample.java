package com.joe.designpattern.observerpattern.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
//        在這裡設置frame屬性
    }

    class AngelListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            System.out.println("Angel:Just do it,your right!");
        }
    }

    class DevilListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            System.out.println("Devil:Angel is right!Just do it!!");
        }
    }
}
