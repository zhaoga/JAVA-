package com.p8;

import java.util.Date;
import java.util.TimerTask;


public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer("显示n");
        TimerTask task = new MyTask1();
        timer.schedule(task,1000,1000);
    }
}

class MyTask1 extends TimerTask {
    int n = 0;

    @Override
    public void run() {
        n++;
        System.out.print(new Date());
        System.out.println("---" + n);
    }
}