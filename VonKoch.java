package com.p7;

import java.awt.*;

public class VonKoch {
    public static void main(String[] args) {
        Frame frame = new Frame("VonKoch");
        frame.setSize(400,200);
        frame.setBackground(Color.lightGray);
        frame.show();
        VonKoch p = new VonKoch(frame);
        p.drawVonKoch(8,p.width);
    }

    private Frame frame;
    private Graphics graphics;
    private int width;
    private int height;
    private double th,curx,cury;
    private final double PI = Math.PI;
    private final double m = 2*(1+Math.cos(85*PI/180));

    public VonKoch(Frame frame) {
        graphics = frame.getGraphics();
        width = frame.getSize().width;
        height = frame.getSize().height;
    }

    void drawVonKoch(int n, double d) {
        if (n==0) {
            double x = curx +d*Math.cos(th*PI/180);
            double y = cury+d*Math.sin(th*PI/180);
            drawLineTo(x,y);
            return;
        }

        drawVonKoch(n-1,d/m);
        th=th+85;
        drawVonKoch(n-1,d/m);
        th=th-170;
        drawVonKoch(n-1,d/m);
        th=th+85;
        drawVonKoch(n-1,d/m);
    }
    void drawLineTo(double x,double y) {
        graphics.drawLine((int) curx,(int) cury, (int) x, (int) y);
        curx = x;
        cury = y;
    }
}
