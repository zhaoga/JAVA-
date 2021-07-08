package com.p4;


class Person{
    String name;
    int age;

    static int x;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name) {
        this.name = name;
        this.age =  -1;
    }

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    Person() {
        this(0, "");
    }

    void sayHello() {
        System.out.println("Hello! My name is " + name);
    }

    void sayHello(Person another) {
        System.out.println("Hello, " + another.name + " ! My name is " + name);
    }

    boolean isOlderThan(int anAge) {
        boolean flg;
        if (age > anAge)
            flg = true;
        else
            flg = false;
        return flg;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
public class Student extends Person{
    String school;
    int score;

    void sayHello(Student another) {
        System.out.println("Hi!");
        if (school == another.school)
            System.out.println("Shoolmates");
    }

    boolean isGoodStudent() {
        return score >=90;
    }

    void testThisSuper() {
        int a;
        a = age;
        a = this.age;
        a = super.age;
    }

    void sayHello() {
        super.sayHello();
        System.out.println("My school is " + school);
    }

    Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    Student(){}

    public static void main(String[] args) {
        Person p = new Person("Liming", 50);
        Student s = new Student("Wangqiang", 20, "PKU");
        Person p2 = new Student("Zhangyi", 18, "THU");
        Student s2 = (Student) p2;
    }
}
