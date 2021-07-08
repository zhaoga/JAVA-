package com.p10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testMenuItem {
    public static void main(String[] args) {
        Frame frame = new Frame("Menu");
        MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);

        Menu m1 = new Menu("file");
        Menu m2 = new Menu("edit");
        Menu m3 = new Menu("help");

        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.setHelpMenu(m3);

        MenuItem mi1 = new MenuItem("New");
        MenuItem mi2 = new MenuItem("Save");
        MenuItem mi3 = new MenuItem("Load");
        MenuItem mi4 = new MenuItem("Quit");

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.addSeparator();
        m1.add(mi4);

        mi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        frame.setSize(250,200);
        frame.setVisible(true);
    }
}
