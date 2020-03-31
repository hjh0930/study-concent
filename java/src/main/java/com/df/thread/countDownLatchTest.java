package com.df.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jifeng
 */
public class countDownLatchTest {
   public static  final CountDownLatch countDown = new CountDownLatch(10);
   public static AtomicInteger atomicInteger = new AtomicInteger(5);
   public static ConcurrentHashMap<String,Integer>  concurrentHashmap = new ConcurrentHashMap<>();
   public static AtomicInteger atomic = new AtomicInteger((11/2));
   public static void main(String[] args) throws InterruptedException {
      BlockingQueue bk = new ArrayBlockingQueue(20);
      ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,3, TimeUnit.SECONDS,bk, new ThreadPoolExecutor.AbortPolicy());
      for (int i = 0;i<10;i++) {
         Thread.sleep(10);
         executor.submit(new Runnable() {
            @Override
            public void run() {
               while (atomicInteger.get()>0) {
                  atomicInteger.getAndDecrement();
                  System.out.println(111+atomicInteger.get());
                  concurrentHashmap.put("key"+atomicInteger.get(),atomicInteger.get());
               }
               System.out.println("11111");
               countDown.countDown();
            }
         });
      }

      try {

         countDown.await();
         System.out.println("2222");
         System.out.println(concurrentHashmap);
         System.out.println("aaaaaa");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

   }

}
