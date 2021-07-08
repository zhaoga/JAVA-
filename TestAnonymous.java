package com.p10;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class TestAnonymous {
    Frame frame = new Frame("匿名内部类测试");
    TextField textField = new TextField(30);

    public TestAnonymous() {
        frame.add(new Label("请按下鼠标左键并移动"), "North");
        frame.add(textField, "South");

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                String s = "鼠标拖动到位置（" + mouseEvent.getX() + "，" + mouseEvent.getY() + "）";
                textField.setText(s);
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
        frame.setSize(300,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TestAnonymous testAnonymous = new TestAnonymous();
    }
}
