package com.p5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassViewer {
    public static void view(Class clz) throws ClassNotFoundException {
        System.out.println("类名称：" + clz.getName());
        System.out.println("是否为介面：" + clz.isInterface());
        System.out.println("是否为基本类型：" + clz.isPrimitive());
        System.out.println("是否为数组对象：" + clz.isArray());
        System.out.println("父类名称：" + clz.getSuperclass().getName());

        Package p = clz.getPackage(); // 取得组件代表对象
        System.out.printf("package %s;%n", p.getName());

        int modifier = clz.getModifiers();  // 取得类型修饰常熟
        System.out.printf("%s %s %s {%n",
                Modifier.toString(modifier),  // 将常数转化为字串表示
                Modifier.isInterface(modifier) ? "interface" : "class",
                clz.getName()            // 取得类名称
        );

        // 取得声明的数据成员代表对象
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            // 显示权限修饰，像是public、protected、private
            System.out.printf("\t%s %s %s; %n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getName(),  // 显示类型名
                    field.getName()             // 显示数据成员名
                    );
        }

        // 取得声明的构造函数代表对象
        Constructor[] constructors = clz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            // 显示权限修饰
            System.out.printf("\t%s %s(); %n",
                    Modifier.toString(constructor.getModifiers()),
                    constructor.getName()  // 显示构造函数名
            );
        }

        // 取得声明的方法成员代表对象
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("\t%s %s %s(); %n",
                    Modifier.toString(method.getModifiers()),  // 显示权限修饰
                    method.getReturnType().getName(),   // 显示返回值类型名称
                    method.getName()
            );
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        try{
            ClassViewer.view(String.class);
            Class clz = Class.forName("java.lang.String");
            ClassViewer.view(clz);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("没有指定类");
        }catch (ClassNotFoundException e) {
            System.out.println("找不到指定类");
        }
    }
}
