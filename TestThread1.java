package com.p8;

public class TestThread1 {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends  Thread {
    public void run() {
        for (int i = 0;i<100;i++)
            System.out.print(" " + i);
    }
}
