package com.p9;

import java.io.*;

class Person implements Serializable{
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

public class SerializeDemo {
    public static void main(String[] args) throws IOException {
        Person[] ps = {
                new Person("Li", 18),
                new Person("Wang", 19)
        };
        String fileName = "s.temp";

        // 序列化
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName)
        );
        for (Person p : ps)
            outputStream.writeObject(p);
        outputStream.close();

        // 反序列化
        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(fileName)
        );
        Person person = null;
        try {
            while ((person=(Person)inputStream.readObject()) != null) {
                System.out.println(person);
            }
        } catch (ClassNotFoundException e) {}
        catch (EOFException e) {}
        inputStream.close();
    }
}
