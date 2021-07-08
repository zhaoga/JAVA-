package com.p10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent {
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        Button button = new Button("Press Me!");
        frame.add(button);

        Monitor bh = new Monitor();
        button.addActionListener(bh);

        frame.pack();
        frame.setVisible(true);
    }
}

class Monitor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("a button has been pressed");
    }
}
