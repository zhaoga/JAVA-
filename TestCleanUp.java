package com.p5;

public class TestCleanUp {
    public static void main(String[] args) {
        PolyLine x = new PolyLine(47);
        try{
            // code
        }finally {
            x.cleanup();
        }
    }
}

class Shape1 {
    Shape1(int i) {
        System.out.println("Shape constructor");
    }
    void cleanup() {
        System.out.println("Shape cleanup");
    }
}

class Line1 extends Shape1 {
    private int start, end;

    public Line1(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing a Line:" + start + "," + end);
    }

    @Override
    void cleanup() {
        System.out.println("Erasing a Line:" + start + "," + end);
        super.cleanup();
    }
}

class PolyLine extends Shape1 {
    private Line1[] line1s = new Line1[10];

    public PolyLine(int i) {
        super(i+1);
        for (int j = 0; j < 10; j++) {
            line1s[j] = new Line1(j,j*j);
        }
        System.out.println("PolyLine constructor");
    }

    @Override
    void cleanup() {
        System.out.println("PolyLine.cleanup()");
        for (int i = 0; i < line1s.length; i++)
            line1s[i].cleanup();
        super.cleanup();
    }
}