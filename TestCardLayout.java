package com.p10;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class TestCardLayout {
    public static void main(String[] args) {
        final Frame frame = new Frame("Card Layout");
        final CardLayout cardLayout = new CardLayout();
        Button[] buttons = new Button[8];
        for (int i=0; i<buttons.length; i++) {
            buttons[i] = new Button("button" + (i+1));
            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getModifiersEx() == InputEvent.BUTTON1_MASK)
                        cardLayout.next(frame);
                    else
                        cardLayout.previous(frame);
                }
            });
        }

        frame.setLayout(cardLayout);
        for (int i =0;i< buttons.length;i++) {
            frame.add("" + (i+1),buttons[i]);
        }
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
