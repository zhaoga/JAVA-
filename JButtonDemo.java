package com.p10;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JButtonDemo extends JApplet {
    JButton b1 = new JButton("JButton 1");
    JButton b2 = new JButton("JButton 2");
    JTextField t = new JTextField(20);
    public void init() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name =
                        ((JButton) actionEvent.getSource()).getText();
                t.setText(name + " Pressed");
            }
        };
        b1.setToolTipText("Press Button will show msg");
        b1.setBorder(new BevelBorder(BevelBorder.RAISED));
        b1.setIcon(new ImageIcon(""));

        b1.addActionListener(al);
        b2.addActionListener(al);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(t);
    }

    public static void main(String[] args) {
        JApplet applet = new JButtonDemo();
        JFrame frame = new JFrame("Test Swing");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(
                applet,BorderLayout.CENTER
        );
        frame.setSize(400,300);
        applet.init();
        applet.start();
        frame.setVisible(true);
    }
}
