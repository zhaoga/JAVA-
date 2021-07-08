package com.p10;

import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {
    JButton button = new JButton("start");
    JLabel label = new JLabel("");
    public MyFrame() {
        this.setTitle("测试");
        this.setSize(300,200);
        label.setFont(new Font("Times New Rome", 0, 48));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(button, BorderLayout.NORTH);
        getContentPane().add(label, BorderLayout.CENTER);
        button.addActionListener(e -> {
            new Thread(() -> {
                for (int i=10;i>=0;i++) {
                    final int j = i;
                    SwingUtilities.invokeLater(() -> {
                        label.setText("" + j);
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (Exception exception) {}
                }
            }).start();
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class InvokeLaterDemo {
    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}
