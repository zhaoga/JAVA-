package com.p5;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RunTimeClassInfo {
    public static void main(String[] args) {
        Object obj = new Color(
                1,1,1
        );
        Class cls = obj.getClass();
        System.out.println("类名：" + cls.getName());
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println("域：" + field.getName() + "：" + field);
        }
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println("方法：" + method.getName() + "：" + method);
        }
    }
}
