package com.p10;

import java.awt.*;
import java.io.File;

public class TesstFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("Flow Layout");

        Button[] buttons = new Button[8];
        for (int i=0; i<buttons.length; i++) {
            buttons[i] = new Button("button" + (i+1));
        }
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));

        for (int i=0; i<buttons.length; i++) {
            frame.add(buttons[i]);
        }

        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
