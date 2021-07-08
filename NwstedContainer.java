package com.p10;

import java.awt.*;

public class NwstedContainer {
    public static void main(String[] args) {
        Frame frame = new Frame("Nested Conttainer");
        Label b0 = new Label("display Area");
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(2,2));
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        frame.add(b0,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
