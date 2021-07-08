package com.p7;

import java.util.Arrays;
import java.util.Random;

public class TestArraysSort {
    static Random r = new Random();
    static String ssource =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz";
    static  char[] src = ssource.toCharArray();

    // Create a random String
    public static String randString(int length) {
        char[] buf = new char[length];
        int rnd;
        for (int i = 0; i < length; i++) {
            rnd = Math.abs(r.nextInt()) % src.length;
            buf[i] = src[rnd];
        }
        return new String(buf);
    }

    //Create a random array of Strings
    public static String[] randStrings(int length, int size) {
        String[] s = new String[size];
        for (int i = 0; i < size; i++)
            s[i] = randString(length);
        return s;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++)
            System.out.print(bytes[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        byte[]b = new byte[15];
        r.nextBytes(b);
        print(b);
        Arrays.sort(b);
        print(b);
        int loc = Arrays.binarySearch(b,b[10]);
        System.out.println("Location of" + b[10] + "=" + loc);

        // Test String sort & search;
        String[] s = randStrings(4,10);
        // print(s);
        Arrays.sort(s);
        loc = Arrays.binarySearch(s,s[4]);
        System.out.println("Location of" + s[4] + "=" + loc);
    }
}
