package com.p7;

import java.util.Date;
import java.util.zip.DataFormatException;

public class GenericMethod {
    public static void main(String[] args) {
        Date date = BeanUtil.<Date>getInstance("java.util.Date");
        System.out.println(date);
    }
}

class BeanUtil {
    public static <T> T getInstance(String clzName) {
        try {
            Class c = Class.forName(clzName);
            return (T) c.newInstance();
        } catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        return null;
    }
}