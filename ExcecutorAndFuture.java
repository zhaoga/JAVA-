package com.p8;

import java.util.concurrent.*;

public class ExcecutorAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("准备计算");
        Future<Long> future = executorService.submit(
                new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return fibonacci(20);
                    }
                }
        );

        System.out.println("主线程可以执行别的事");

        try {
            Thread.sleep(2000);
            System.out.println("异步取得结果：");
            System.out.println(future.get());
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }
    }

    static long fibonacci(int n) {
        if (n==0||n==1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
