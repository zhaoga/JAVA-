package com.p7;

import java.awt.*;

public class Julia {
    public static void main(String[] args) {
        Frame frm = new Frame("Julia");
        frm.setSize(300,300);
        frm.show();
        Julia p = new Julia(frm);
        p.drawJulia();
    }

    private Frame frm;
    private Graphics graphics;
    private int width;
    private int height;

    public Julia(Frame frm) {
        graphics = frm.getGraphics();
        width = frm.getWidth();
        height = frm.getHeight();
    }

    public void drawJulia() {
        final double a = 0.5;
        final double b = 0.55;

        for (double x0 = -1.5;x0<1.5;x0+=0.01)
            for (double y0=-1.5;y0<1.5;y0+=0.01) {
                double x = x0, y = y0;
                int n;
                for (n=1;n<100;n++) {
                    double x2 = x*x-y*y+a;
                    double y2 = 2*x*y+b;
                    x=x2;
                    y=y2;
                    if (x*x+y*y>4)
                        break;
                }
                pSet(x0,y0,n);
            }
    }

    public void pSet(double x, double y, int n) {
        graphics.setColor(new Color(n* 0xff8855));
        graphics.drawLine(
                (int) (x*width/3+width/2),
                (int) (y*height/3+height/2),
                (int) (x*width/3+width/2),
                (int) (y*height/3+height/2)
        );
    }
}
