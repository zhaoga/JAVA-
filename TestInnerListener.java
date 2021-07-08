package com.p10;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TestInnerListener {
    Frame frame = new Frame("内部类测试");
    TextField textField = new TextField(30);

    public TestInnerListener() {
        frame.add(new Label("请按下鼠标左键并拖动"), "North");
        frame.add(textField, "South");

        frame.setBackground(new Color(120,175,175));
        frame.addMouseMotionListener(new InnerMonitor());
        frame.setSize(300,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Object t = new TestInnerListener();
    }

    private class InnerMonitor implements MouseMotionListener,
            MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            String s = "鼠标已进入窗体";
            textField.setText(s);
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            String s = "鼠标已移出窗体";
            textField.setText(s);
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            String s = "鼠标拖动到位置（" + mouseEvent.getX() + "，" + mouseEvent.getY() + "）";
            textField.setText(s);
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
    }
}
