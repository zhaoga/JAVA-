package com.p7;

import java.util.StringTokenizer;

public class TestStringTokenizer {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("This is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
