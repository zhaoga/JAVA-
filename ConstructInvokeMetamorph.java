package com.p5;

public class ConstructInvokeMetamorph {
    public static void main(String[] args) {
        Person2 p = new Student2("李明",18,"北大");
    }
}

class Person2 {
    String name = "未命名";
    int age = -1;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
        sayHello();
    }

    void sayHello() {
        System.out.println("我是一个人，我名叫：" + name + "，年龄为：" + age);
    }
}

class Student2 extends Person2 {
    String school = "未定学校";

    public Student2(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @Override
    void sayHello() {
        System.out.println("我是学生，我叫：" + name + "，年龄为：" + age + "，学校在：" + school);
    }
}