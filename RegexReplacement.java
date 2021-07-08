package com.p9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplacement {
    public static void main(String[] args) throws Exception{
        Pattern p = Pattern.compile("cat");
        Matcher matcher = p.matcher(
                "one cat,two cats in the yard"
        );
        StringBuffer stringBuffer = new StringBuffer();
        boolean result = matcher.find();
        while (result) {
            matcher.appendReplacement(stringBuffer,"dog");
            result = matcher.find();
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }
}
