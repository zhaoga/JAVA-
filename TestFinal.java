package com.p4;

public class TestFinal {
    public static int totalNumber = 5;
    public static final int id = 0;

    /*public TestFinal() {
        id = ++totalNumber;
    }*/

    public static void main(String[] args) {
        TestFinal t = new TestFinal();
        System.out.println(t.id);
        final int i = 10;
        final int j;
        j = 20;
    }
}
