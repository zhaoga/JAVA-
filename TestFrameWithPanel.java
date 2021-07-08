package com.p10;

import java.awt.*;

public class TestFrameWithPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("My Test Frame");
        frame.setSize(300,200);
        frame.setLocation(50,50);
        frame.setBackground(Color.blue);

        Panel panel = new Panel();
        panel.setSize(150,100);
        panel.setLocation(50,50);
        panel.setBackground(Color.green);

        Button button = new Button("ok");
        button.setSize(80,20);
        button.setLocation(50,50);
        button.setBackground(Color.red);

        frame.setLayout(null);
        panel.setLayout(null);
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }
}
