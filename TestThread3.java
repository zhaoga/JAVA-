package com.p8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TestThread3 {
    public static void main(String[] args) {
        Runner r1 = new Runner(1);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Runner r2 = new Runner(2);
        Thread t4 = new Thread(r2);
        Thread t5 = new Thread(r2);
        Thread t6 = new Thread(r2);

        Timer timer = new Timer();
        Thread t7 = new Thread(timer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}

class Runner implements Runnable {
    int id;

    public Runner(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            System.out.println("ID:" + id + " No." + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {}
        }
    }
}

class Timer implements Runnable {

    public Timer() {
    }

    public Timer(String n) {
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(new SimpleDateFormat().format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public void schedule(TimerTask task, int i, int i1) {
    }
}
