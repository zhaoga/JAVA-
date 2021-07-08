package com.p8;

import com.sun.source.tree.NewArrayTree;

import java.util.function.IntUnaryOperator;

public class ThreadJoin {
    public static void main(String[] args) {
        Runner2 runner2 = new Runner2();
        Thread thread = new Thread(runner2);
        thread.start();
        /*try {
            thread.join();
        } catch (InterruptedException e) {}
        */
        for (int i = 0; i< 10;i++){
            System.out.println("\t" + i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {}
        }
    }
}

class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i<10;i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}
