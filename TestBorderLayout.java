package com.p10;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("Border Layout");

        frame.setLayout(new BorderLayout());
        frame.add(new Button("North"),BorderLayout.NORTH);
        frame.add(new Button("South"),BorderLayout.SOUTH);
        frame.add(new Button("East"),BorderLayout.EAST);
        frame.add(new Button("West"),BorderLayout.WEST);
        frame.add(new Button("Center"),BorderLayout.CENTER);

        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
