package com.p7;

import java.util.LinkedList;

public class TestQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 5; i++)
            queue.enqueue("" + i);
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}

class MyQueue extends LinkedList {
    void enqueue(Object obj) {
        addLast(obj);
    }
    Object dequeue() {
        return removeFirst();
    }
    public boolean isEmpty() {
        return super.isEmpty();
    }
}