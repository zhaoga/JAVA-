package com.p10;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class SimplleMouseWidthVector extends Applet {
    private Vector points = new Vector();
    public void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(new Point(e.getX(),e.getY()));
                repaint();
            }
        });
    }
    public void update(Graphics graphics) {
        paint(graphics);
    }
    public void paint(Graphics graphics) {
        for (int i=0;i<points.size();i++) {
            Point point = (Point) points.elementAt(i);
            graphics.drawString("x", point.x, point.y);
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame("MouseClick");
        SimplleMouseWidthVector simplleMouseWidthVector = new SimplleMouseWidthVector();
        simplleMouseWidthVector.init();
        simplleMouseWidthVector.start();
        frame.add("Center",simplleMouseWidthVector);
        frame.setSize(400,300);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.show();
    }
}
