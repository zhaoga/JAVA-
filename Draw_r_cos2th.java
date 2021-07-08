package com.p10;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Draw_r_cos2th extends Applet {
    public void paint(Graphics graphics){
        double w = getSize().width/2;
        double h = getSize().height/2;
        graphics.setColor(Color.blue);
        for (double th = 0;th<10;th+=0.003) {
            double r = Math.cos(16*th)*h;
            double x=r*Math.cos(th)+w;
            double y=r*Math.sin(th)+h;
            graphics.drawOval((int) x-1,(int) y-1,3,3);
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Draw");
        Draw_r_cos2th p = new Draw_r_cos2th();
        p.init();
        p.start();
        frame.add(p);
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
