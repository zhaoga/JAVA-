package com.p10;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestMultiListener {
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        TextField msg = new TextField(20);

        Monitor1 m1 = new Monitor1(frame);
        Monitor2 m2 =new Monitor2(msg,frame);
        frame.addWindowListener(m1);
        frame.addMouseMotionListener(m2);
        frame.add(msg, BorderLayout.SOUTH);
        frame.setSize(200,160);
        frame.setVisible(true);
    }
}

class Monitor1 implements WindowListener {
    private Frame frame;

    public Monitor1(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}

class Monitor2 implements MouseMotionListener {
    private TextField msg;
    private Frame frame;
    private boolean bDragged = false;

    public Monitor2(TextField msg, Frame frame) {
        this.msg = msg;
        this.frame = frame;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        msg.setText("MouseDraged:" + mouseEvent.getX() + "," + mouseEvent.getY());
        if (!bDragged) {
            frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            bDragged = false;
        }
        frame.getGraphics().drawLine(mouseEvent.getX(),mouseEvent.getY(),mouseEvent.getX(),
                mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        msg.setText("MouseMoved:" + mouseEvent.getX() + "," + mouseEvent.getY());
        if (bDragged) {
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
