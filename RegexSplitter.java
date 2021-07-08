package com.p9;

import java.util.regex.Pattern;

public class RegexSplitter {
    public static void main(String[] args) throws Exception{
        Pattern pattern = Pattern.compile("[,\\s]+");
        String[] result =
                pattern.split("one,two,three,for,five");
        for (int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }
}
