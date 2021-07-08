package com.p7;

class MyDate {
    int day, month, year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

class MyOkDate extends MyDate {
    public MyOkDate(int day, int month, int year) {
        super(day, month, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyOkDate) {
            MyOkDate m = (MyOkDate) obj;
            if (m.day == day && m.month == month && m.year == year)
                return true;
        }
        return false;
    }
}

public class TestEqualsObject {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(24,3,2001);
        MyDate m2 = new MyDate(24,3,2001);
        System.out.println(m1.equals(m2));
        m1 = new MyOkDate(24,3,2001);
        m2 = new MyOkDate(24,3,2001);
        System.out.println(m1.equals(m2));
    }
}
