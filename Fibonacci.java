package com.p3;

public class Fibonacci {
    public static void main(String[] args) {
        int i;
        int f[] = new int[10];
        f[0] = f[1] = 1;
        for ( i = 2 ; i < 10; i++)
            f[i] = f[i-1] + f[i-2];
        for (i = 1; i<=10; i++)
            System.out.println("F[" +i+"]=" + f[i-1]);
    }
}
