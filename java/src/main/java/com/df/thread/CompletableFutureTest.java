package com.df.thread;

import com.sun.tools.javac.util.Abort;

import java.util.concurrent.*;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 100; i++) {
            CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(threadPoolExecutor.getActiveCount());
                }
                return Thread.currentThread().getName();
            }, threadPoolExecutor);
            System.out.println(completableFuture.get());
        }


        CompletableFuture async = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
