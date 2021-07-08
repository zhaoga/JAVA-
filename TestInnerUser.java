package com.p5;


public class TestInnerUser {
    public static void main(String[] args) {
        Parcel p =new Parcel();
        Parcel.Contents c = p.new Contents(33);
        Parcel.Destination d = p.new Destination("Hawii");
        p.setValue(c,d);
        p.ship();
    }
}

class Parcel {
    private Contents c;
    private Destination d;

    class Contents {
        private int i;

        Contents(int i) {
            this.i = i;
        }
        int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    void setValue(Contents c, Destination d) {
        this.c = c;
        this.d = d;
    }

    void ship() {
        System.out.println("运输" + c.value() + "到" + d.readLabel());
    }

    public void testShip() {
        c = new Contents(22);
        d = new Destination("Tanzania");
        ship();
    }
}
