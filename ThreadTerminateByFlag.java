package com.p8;

import java.util.Date;

public class ThreadTerminateByFlag {
    public static void main(String[] args) {
        Timer2 timer = new Timer2();
        Thread thread = new Thread(timer);
        thread.setName("Timer");
        thread.start();

        for (int i = 0; i<100;i++){
            System.out.print("\r" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }

        timer.stopRun();
    }
}

class Timer2 implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.print("\r\t" + new Date() + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
        System.out.println("\n" + Thread.currentThread().getName() + "Stop");
    }
    public void stopRun() {
        flag = flag;
    }
}
