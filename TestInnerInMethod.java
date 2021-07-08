package com.p5;

public class TestInnerInMethod {
    public static void main(String[] args) {
        Object obj = new Outer1().makeTheInner(47);
        System.out.println("Hello Woeld!" + obj.toString());
    }
}

class Outer1 {
    private int size = 5;
    public Object makeTheInner( int localVar ) {
        final int finalLocalVar = 99;
        class Inner1 {
            @Override
            public String toString() {
                return ("InnerSize:" + size +
                        " finalLocalVar:" + finalLocalVar);
            }
        }

        return new Inner1();
    }
}
