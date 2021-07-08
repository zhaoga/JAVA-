package com.p5;


import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Date;

// 定义一个注记
@Target(ElementType.METHOD)  // 这个表明可以用于方法上
@Retention(RetentionPolicy.RUNTIME)  // 这个表明可以用反射来读取
@Documented  // 这个表明它会生成到javadoc中
@interface DebugTime {
    boolean value() default true;
    long timeout() default 100;
    String msg();
    int[] other() default {};
}

// 使用注解
class MyClass {
    @DebugTime( value = true, timeout = 10, msg = "时间太长", other = {1,2,3} )
    public double fib(int n) {
        if (0 == n || 1 == n)
            return 1;
        else
            return fib(n-1) + fib(n-2);
    }
}

// 在运行过程中读取注解
public class DebugTool {
    public static void main(String[] args) throws NoSuchMethodException{
        MyClass obj = new MyClass();
        Class clz = obj.getClass();
        for (Method m : clz.getDeclaredMethods()) {
            System.out.println( m );
            for (Annotation ann : m.getAnnotations()) {
                System.out.println( ann.annotationType().getName() );
            }
        }

        Method method = clz.getMethod("fib", int.class);
        System.out.println(method);
        if (method.isAnnotationPresent(DebugTime.class)) {
            DebugTime debug = method.getAnnotation(DebugTime.class);
            boolean requireDebug = debug.value();
            long timeout = debug.timeout();
            if (requireDebug) {
                Date t0 = new Date();
                double fib = obj.fib(40);
                Date t1 = new Date();
                long time = t1.getTime() - t0.getTime();
                System.out.println("用时：" + time);
                if (time > timeout) {
                    System.out.println(debug.msg());
                }
            }
        }
    }
}
