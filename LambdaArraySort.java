package com.p5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaArraySort {
    public static void main(String[] args) {
        Person3[] person3s = new Person3[] {
                new Person3("Ted", 18,91),
                new Person3("Charlotte",19,88),
                new Person3("Michael",20,99),
                new Person3("Matthew",21,84)
        };

        // 使用匿名类实现接口Comparator
        Arrays.sort(person3s, new Comparator<Person3>() {
            @Override
            public int compare(Person3 p1, Person3 p2) {
                return ((Person3)p1).age - ((Person3)p2).age;
            }
        });

        // 使用Lambda表达式赋值给接口
        Comparator<Person3> compareAge = (p1,p2)->p1.age-p2.age;
        Arrays.sort(person3s, compareAge);

        // 直接使用Lambda表达式做函数的参数
        Arrays.sort(person3s, (p1,p2)->p1.age-p2.age);
        Arrays.sort(person3s, (p1,p2)->(int)(p1.score-p2.score));
        Arrays.sort(person3s, (p1,p2)->p1.name.compareTo(p2.name));
        Arrays.sort(person3s, (p1,p2)->p1.name.compareToIgnoreCase(p2.name));

        // 使用函数表达式
        Comparator<Person3> cf = Person3::better;
        Arrays.sort(person3s, cf);
        Arrays.sort(person3s, Person3::better);

        // 使用系统更高阶的函数comparing
        Arrays.sort(person3s, Comparator.comparing(Person3::getName));

        for (Person3 person3 : person3s)
            System.out.println(person3);
    }
}

class Person3 {
    public String name;
    public int age;
    public double score;

    public Person3(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    /*@Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }*/

    public String toString() {
        return String.format("%s[%d](%f)", name,age,score);
    }

    public static int better(Person3 p1, Person3 p2) {
        return (int)(p2.score-p1.score);
    }
}