package com.p8;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        CubbyHole cubbyHole = new CubbyHole();
        Producer p1 = new Producer(cubbyHole,1);
        Consumer c1 = new Consumer(cubbyHole, 1);

        p1.start();
        c1.start();
    }
}

class Producer extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Producer(CubbyHole cubbyHole, int number) {
        this.cubbyHole = cubbyHole;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i =0;i<10;i++) {
            cubbyHole.put(i);
            System.out.println("Producer #" + this.number + " put: " + i);
            try {
                sleep((int) (Math.random()*100));
            } catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Consumer(CubbyHole cubbyHole, int number) {
        this.cubbyHole = cubbyHole;
        this.number = number;
    }

    @Override
    public void run() {
        int value = 0;
        for (int i =0;i<10;i++) {
            value = cubbyHole.get();
            System.out.println("Consumer #" + this.number + " got: " + value);
        }
    }
}

class CubbyHole {
    private int seq;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        available = false;
        notify();
        return seq;
    }

    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        seq = value;
        available = true;
        notify();
    }
}