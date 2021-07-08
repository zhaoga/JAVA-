package com.p5;

public class ConstructSequence {
    public static void main(String[] args) {
        Person1 p = new Student1("李明",18,"北大");
    }
}

class Person1 {
    String name = "未命名";
    int age = 1;

    public Person1(String name, int age) {
        System.out.println("开始构造Person()，此时this.name=" + this.name + "，this.age=" + this.age);
        this.name = name;
        this.age = age;
        System.out.println("Person()构造完成，此时this.name=" + this.name + "，this.age=" + this.age);
    }
}

class Student1 extends Person1 {
    String school = "未定学校";

    public Student1(String name, int age, String school) {
        super(name, age);
        System.out.println("开始构造Student()，此时this.name=" + this.name + "，this.age=" + this.age +
                "，this.school=" + this.school);
        this.school = school;
        System.out.println("Student()构造完成，此时this.name=" + this.name + "，this.age=" + this.age +
                "，this.school=" + this.school);
    }
}
