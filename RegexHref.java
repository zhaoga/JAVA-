package com.p9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHref {
    public static void main(String[] args) {
        String patternString =
                "\\s*(href|src)\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))";
        String text = "<a href=\"http:aaa.htm\">bbb</a><img src=\"http://bb.com/pic.jpg\">";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            buffer.append("捕获到" +matcher.group());
            buffer.append(" 其中网址为" + matcher.group(2));
            buffer.append("\r\n");
        }
        System.out.println(buffer.toString());
    }
}
