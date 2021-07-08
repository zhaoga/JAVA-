package com.p9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyByChar {
    public static void main(String[] args) {
        try {
            FileReader input = new FileReader("FileCopyByChar.java");
            FileWriter output = new FileWriter("temo.txt");
            int c = input.read();
            while (c!=-1) {
                output.write(c);
                System.out.print((char) c);
                c = input.read();
            }
            input.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
