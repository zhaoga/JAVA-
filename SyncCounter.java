package com.p8;

public class SyncCounter {
    public static void main(String[] args) {
        Num num = new Num();
        Thread counter1 = new Counter(num);
        Thread counter2 = new Counter(num);

        for (int i =0;i<10;i++) {
            num.testEquals();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}
class Num {
    private int x =0;
    private int y=0;
    synchronized void increase(){
        x++;
        y++;
    }
    synchronized void testEquals(){
        System.out.println(x+","+y+" : " + (x==y));
    }
}
class Counter extends Thread {
    private Num num;

    public Counter(Num num) {
        this.num = num;
        this.start();
    }

    @Override
    public void run() {
        while (true)
            num.increase();
    }
}