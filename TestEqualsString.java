package com.p7;

public class TestEqualsString {
    public static void main(String[] args) {
        String name1 = new String("LiMing");
        String name2 = new String("LiMing");

        System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));

        String name3 = "LiMing";
        String name4 = "LiMing";

        System.out.println(name3 == name4);
        System.out.println(name3.equals(name4));
    }
}
