package com.p10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMultiObjectOneListener {
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        Button button = new Button("Start");
        TextField textField = new TextField("test");

        Monitor3 bh = new Monitor3();
        button.addActionListener(bh);
        textField.addActionListener(bh);
        frame.add(button,"North");
        frame.add(textField,"Center");
        frame.pack();
        frame.setVisible(true);
    }
}

class Monitor3 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("a bunttom " + actionEvent.getSource() +
                " has been pressed." + " command is:" +
                actionEvent.getActionCommand());
    }
}
