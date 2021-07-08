package com.p7;

import java.awt.*;

public class CaylerTree {
    public static void main(String[] args) {
        Frame frame = new Frame("CayleyTree");
        frame.setSize(400,400);
        frame.setBackground(Color.lightGray);
        frame.show();
        CaylerTree p = new CaylerTree(frame);
        p.drawCayleyTree(10,200,400,100,-Math.PI/2);
    }

    private Frame frame;
    private Graphics graphics;
    public  int width;
    private int height;
    private final double PI = Math.PI;
    private final double th1 = 30*PI/180;
    private final double th2 = 20*PI/180;
    private final double per = 0.7;
    private final double per1 = 0.7;
    private final double per2 = 0.6;

    public CaylerTree(Frame frame) {
        graphics = frame.getGraphics();
        width = frame.getSize().width;
        height = frame.getSize().height;
    }

    void drawCayleyTree(int n,double x0,double y0, double leng, double th) {
        if (0==n) return;

        double x1=x0+leng*Math.cos(th);
        double y1=y0+leng*Math.sin(th);

        drawLine(x0,y0,x1,y1);
        drawCayleyTree(n-1,x1,y1,per*leng,th+th1);
        drawCayleyTree(n-1,x1,y1,per*leng,th-th1);
    }
    void drawLine(double x0,double y0, double x1, double y1) {
        graphics.drawLine((int) x0,(int) y0,(int) x1,(int) y1);
    }
}
