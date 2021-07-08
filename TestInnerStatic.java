package com.p5;

public class TestInnerStatic {
    public static void main(String[] args) {
        A.B a_b = new A().new B();
        A a = new A();
        A.B ab = a.new B();

        Outer.Inner oi = new Outer.Inner();
    }
}

class A1 {
    private int x;
    void m() {
        new B1();
    }
    static void sm() {
        // new B();         // error
    }
    class B1 {
        B1() { x = 5; }
    }
}

class Outer {
    static class Inner {}
}
