package com.p5;

public class TestVirtualInvoke {
    static void doStuff( Shape shape ) {
        shape.draw();
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        Triangle t = new Triangle();
        Line l = new Line();
        doStuff(c);
        doStuff(t);
        doStuff(l);
    }
}

class Shape {
    void draw() { System.out.println("Shape Drawing"); }
}

class Circle extends Shape {
    @Override
    void draw() { System.out.println("Draw Circle"); }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Draw Three Lines");
    }
}

class Line extends Shape {
    @Override
    void draw() {
        System.out.println("Draw Line");
    }
}
