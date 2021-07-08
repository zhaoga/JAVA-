package com.p7;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class TestCollectionsSort {
    public static void main(String[] args) {
        Vector school = new Vector();
        school.addElement( new Person("Li", 23));
        school.addElement( new Person("Wang", 28));
        school.addElement( new Person("Zhang", 21));
        school.addElement( new Person("Tang", 19));
        school.addElement( new Person("Chen", 22));
        System.out.println(school);

        Collections.sort(school, new PersonComparator());
        System.out.println(school);

        int index = Collections.binarySearch(
                school, new Person("Li", 23),
                new PersonComparator()
        );
        if (index >= 0)
            System.out.println("Found:" + school.elementAt(index));
        else
            System.out.println("Not Found!");
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PersonComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Person p1 = (Person) o;
        Person p2 = (Person) t1;
        if (p1.age > p2.age) return 1;
        else if (p1.age < p2.age) return -1;
        return 0;
    }
}