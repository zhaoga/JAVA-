package com.p7;

import java.util.*;

public class TestCollectionsSort2 {
    public static void main(String[] args) {
        List<Person2> school = new ArrayList<Person2>();
        school.add(new Person2("Li",23));
        school.add(new Person2("Wang",28));
        school.add(new Person2("Zhang",21));
        school.add(new Person2("Tang",19));
        school.add(new Person2("Chen",22));
        school.add(new Person2("Zhao",22));
        System.out.println(school);

        Collections.sort(school,(p1,p2)->p1.age - p2.age);
        System.out.println(school);

        int index = Collections.binarySearch(
                school, new Person2("Li",23),(p1,p2)-> p1.age - p2.age
        );

        if (index >= 0)
            System.out.println("Found:" + school.get(index));
        else
            System.out.println("Not Found!");
    }
}
class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
