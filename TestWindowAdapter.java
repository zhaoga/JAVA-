package com.p10;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class TestWindowAdapter {
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        TextField msg = new TextField(20);
        Monitor4 m1 = new Monitor4(frame);
        frame.addWindowListener(m1);
        frame.add(msg, BorderLayout.SOUTH);
        frame.setSize(200,160);
        frame.setVisible(true);
    }
}

class Monitor4 extends WindowAdapter {
    private Frame frame;

    public Monitor4(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
