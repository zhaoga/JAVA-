package com.p5;

class Person {
    String name;
    int age;
    Person() {}
    Person( String name, int age ) {
        this.name = name;
        this.age = age;
        System.out.println("In Person(String,int)");
    }
}

class Student extends Person {
    String school;
    Student() {
        this(null,0,null);
        System.out.println("In Student()");
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
        System.out.println("In Student(String,int,String)");
    }
}

class Graduate extends Student {
    Graduate() {
        System.out.println("In Graduate()");
    }
}

public class ConstructCallThisAndSuper {
    public static void main(String[] args) {
        Person p = new Graduate();
    }
}
