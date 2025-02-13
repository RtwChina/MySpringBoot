package com.xiaour.spring.boot.base.ThreeThreadsAlternatelyPrint;

import org.apache.poi.hpsf.ReadingNotSupportedException;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印ABC，有三种方案：synchronized,Lock,Lock.condition,semaphore
 * 注意：
 * 1. 普通的Object,先执行synchronized后，可以通过wait 和 notifyAll
 * 2. lock的话，是lock和unLock
 * 3. Lock.condition,先进行lock,然后通过condition的await和notify
 *
 * @author rtw
 * @since 2025/2/13
 */
public class Solution_Lock {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();

        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();

    }

    public static Lock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();

    public static int numSum = 0;

    public static int printNum = 0;

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 三个线程只有一个线程可以抢到锁
                    lock.lock();
                    // 判断当前线程是否可以打印
                    if (numSum % 3 == 0) {
                        System.out.println(0 + "，" + printNum++);
                        numSum++;
                        Thread.sleep(1000);
                        conditionB.signalAll();
                    } else {
                        conditionA.await();
                    }
                    lock.unlock();
                } catch (Exception e) {

                }
            }
        }
    }
    public static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 三个线程只有一个线程可以抢到锁
                    lock.lock();
                    // 判断当前线程是否可以打印
                    if (numSum % 3 == 1) {
                        System.out.println(1 + "，" + printNum++);
                        numSum++;
                        Thread.sleep(1000);
                        conditionC.signalAll();
                    } else {
                        conditionB.await();
                    }
                    lock.unlock();
                } catch (Exception e) {

                }
            }
        }
    }
    public static class ThreadC implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 三个线程只有一个线程可以抢到锁
                    lock.lock();
                    // 判断当前线程是否可以打印
                    if (numSum % 3 == 2) {
                        System.out.println(2 + "，" + printNum++);
                        numSum++;
                        Thread.sleep(1000);
                        conditionA.signalAll();
                    } else {
                        conditionC.await();
                    }
                    lock.unlock();
                } catch (Exception e) {

                }
            }
        }
    }
}
