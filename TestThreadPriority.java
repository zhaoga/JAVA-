package com.p8;

public class TestThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner3(1));
        Thread t2 = new Thread(new Runner3(2));
        Thread t3 = new Thread(new Runner3(3));

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Runner3 implements Runnable {
    int id;

    public Runner3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i<100;i++) {
            if (i%100 == 0)
                System.out.print("\r");
            Thread.yield();
            System.out.print(id);
        }
    }
}
