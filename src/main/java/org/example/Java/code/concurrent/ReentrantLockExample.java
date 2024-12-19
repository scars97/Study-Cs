package org.example.Java.code.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() {
        lock.lock(); // 락 획득
        try {
            System.out.println(Thread.currentThread().getName() + " - 작업 시작");
            Thread.sleep(1000); // 작업 수행
            System.out.println(Thread.currentThread().getName() + " - 작업 종료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 반드시 락 해제
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        Thread t1 = new Thread(example::performTask, "Thread-1");
        Thread t2 = new Thread(example::performTask, "Thread-2");

        t1.start();
        t2.start();
    }
}
