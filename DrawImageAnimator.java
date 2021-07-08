package com.p10;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class DrawImageAnimator extends Frame {
    private Image[] images;
    private int curImage;
    private boolean bStop;
    private MyThread thread;

    public DrawImageAnimator(String s){
        super(s);
        final String dir = "F://code//java_code//p1//pic";
        String[] files = new File(dir).list();
        int num = files.length<=10? files.length : 10;
        images = new Image[num];
        for (int i=0;i<num;i++) {
            images[i]=Toolkit.getDefaultToolkit().createImage(
                    dir+"//"+files[i]
            );
        }
        setSize(400,700);
        show();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                bStop=true;
                System.exit(0);
            }
        });
        thread=new MyThread();
        thread.start();
    }
    public void paint(Graphics graphics){
        graphics.drawImage(images[curImage],0,0,this);
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            while (!bStop){
                repaint();
                try {
                    sleep(1000);
                }catch (InterruptedException e) {}
                curImage++;
                if (curImage==images.length)
                    curImage=0;
            }
        }
    }

    public static void main(String[] args) {
        Object f = new DrawImageAnimator("DrawImageAnimator");
    }
}
