package com.p8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer1 implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i =0;i<=10;i++) {
            try {
                Thread.sleep((int) (Math.random()*10));
                queue.put(i);
                System.out.print("生产" + i + ".");
            } catch (InterruptedException e) {}
        }
    }
}

class Comsumer1 implements Runnable {
    private BlockingQueue<Integer> queue;

    public Comsumer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i=0; i<=10;i++) {
            try {
                Thread.sleep((int) (Math.random()*10));
                Integer product = queue.take();
                System.out.print("消费" + product + ".");
            } catch (InterruptedException e) {}
        }
    }
}

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue<Integer>(1);
        new Thread(new Producer1(queue)).start();
        new Thread(new Comsumer1(queue)).start();
    }
}
