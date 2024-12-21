package org.example.Java.code.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMapExample example = new ConcurrentHashMapExample();

        //Long keyTest = example.keySynchronized();
        Long valueTest = example.valueIsNotSynchronized();

        //System.out.println(keyTest);
        System.out.println(valueTest);
    }

    public Long keySynchronized() throws InterruptedException {
        ConcurrentHashMap<Long, Long> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            //System.out.println(Thread.currentThread().getName() + " : 1 - " + LocalDateTime.now());
            map.put(1L, 11L);
        };
        Runnable task2 = () -> {
            //System.out.println(Thread.currentThread().getName() + " : 2 - " + LocalDateTime.now());
            map.put(1L, 22L);
        };

        executor.submit(task1);
        executor.submit(task2);

        executor.shutdown();
        Thread.sleep(1000);

        return map.get(1L);
    }

    public Long valueIsNotSynchronized() throws InterruptedException {
        ConcurrentHashMap<Long, Long> map = new ConcurrentHashMap<>();

        map.put(1L, 11L);

        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " : 1 - " + LocalDateTime.now());
            Long value = map.get(1L);
            map.put(1L, value + 1);
        };

        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName() + " : 2 - " + LocalDateTime.now());
            Long value = map.get(1L);
            map.put(1L, value + 1);
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(task1);
        executor.submit(task2);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        return map.get(1L);
    }

}
