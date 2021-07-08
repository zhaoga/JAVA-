package com.p8;

import javax.xml.crypto.Data;
import java.util.Date;

public class TestThreadDaemon {
    public static void main(String[] args) {
        Thread t = new MyThread1();
        t.setDaemon(true);
        t.start();

        System.out.println("Main--" + new Date());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {}
        System.out.println("Main End");
    }
}
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i =0;i<10;i++) {
            System.out.println(i+"--" + new Date());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}
