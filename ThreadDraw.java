package com.p8;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadDraw extends Applet {
    MovingShape[] shapes;

    public void init() {
        setLayout(null);
        setSize(426, 266);

        shapes = new MovingShape[10];
        for (int i = 0; i < shapes.length; i++)
            shapes[i] = new MovingShape(this);
    }

    public void start() {
        for (int i = 0; i < shapes.length; i++) ;
        // shapes[i].start();
        super.start();
    }

    public void stop() {
        for (int i = 0; i < shapes.length; i++)
            shapes[i].suspend();
        super.stop();
    }

    public void destroy() {
        for (int i = 0; i < shapes.length; i++)
            shapes[i].stop();
        super.destroy();
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(450, 300);
        ThreadDraw p = new ThreadDraw();
        frame.add(p);
        frame.setVisible(true);
        p.init();
        p.start();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class MovingShape extends Thread {
        boolean bContinue = false;
        private int size = 100;
        private int speed = 10;
        private Color color;
        private int type;
        private int x, y, w, h, dx, dy;
        protected Component app;

        public MovingShape(Component app) {
            this.app = app;
            x = (int) (Math.random() * app.getSize().width);
            y = (int) (Math.random() * app.getSize().height);
            w = (int) (Math.random() * size);
            h = (int) (Math.random() * size);
            dx = (int) (Math.random() * speed);
            dy = (int) (Math.random() * speed);
            color = new Color(
                    (int) (Math.random() * 128 + 128),
                    (int) (Math.random() * 128 + 128),
                    (int) (Math.random() * 128 + 128)
            );
            type = (int) (Math.random() * 3);
            bContinue = true;
            this.start();
        }

        public void run() {
            while (true) {
                x += dx;
                y += dy;
                if (x < 0 || x + w > app.getSize().width)
                    dx = -dx;
                if (y < 0 || y + h > app.getSize().height)
                    dy = -dy;
                Graphics graphics = app.getGraphics();

                switch (type) {
                    case 0:
                        graphics.setColor(color);
                        graphics.fillRect(x, y, w, h);
                        graphics.setColor(Color.black);
                        graphics.drawRect(x, y, w, h);
                        break;
                    case 1:
                        graphics.setColor(color);
                        graphics.fillOval(x, y, w, h);
                        graphics.setColor(Color.black);
                        graphics.fillOval(x, y, w, h);
                        break;
                    case 2:
                        graphics.setColor(color);
                        graphics.fillRoundRect(x, y, w, h, w / 5, h / 5);
                        graphics.setColor(Color.black);
                        graphics.drawRoundRect(x, y, w, h, w / 5, h / 5);
                        break;
                }
                try {
                    Thread.sleep(130);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
