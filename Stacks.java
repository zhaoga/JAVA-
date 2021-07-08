package com.p7;

import java.util.Stack;

public class Stacks {
    static String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"
    };

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < months.length; i++) {
            stack.push(months[i] + "");
        }
        System.out.println("stack = " + stack);
        System.out.println("popping elements");
        while (!stack.empty())
            System.out.println(stack.pop());
    }
}
