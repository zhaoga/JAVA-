package com.p5;

public class GetClass {
    public static void main(String[] args) {
        Class c1 = String.class;
        System.out.println(c1);

        String stringExample = "abc";
        Class c2 = stringExample.getClass();
        System.out.println(c2);

        try{
            Class c3 = Class.forName("java.lang.String");
            System.out.println(c3);
        }catch (ClassNotFoundException exception){
            System.out.println(exception);
        }
    }
}
