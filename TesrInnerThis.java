package com.p5;

public class TesrInnerThis {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        b.mb(333);
    }
}

class A {
    private int s = 111;
    public class B {
        private int s = 222;

        public void mb(int s) {
            System.out.println(s);
            System.out.println(this.s);
            System.out.println(A.this.s);
        }
    }
}
