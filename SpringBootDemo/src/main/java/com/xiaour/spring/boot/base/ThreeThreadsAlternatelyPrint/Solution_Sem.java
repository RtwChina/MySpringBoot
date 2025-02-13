package com.xiaour.spring.boot.base.ThreeThreadsAlternatelyPrint;

import java.util.concurrent.Semaphore;

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
public class Solution_Sem {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();

        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();

    }

    public static Semaphore semaphoreA = new Semaphore(1);
    public static Semaphore semaphoreB = new Semaphore(0);
    public static Semaphore semaphoreC = new Semaphore(0);

    public static int numSum = 0;

    public static int printNum = 0;

    public static class ThreadA implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    semaphoreA.acquire();
                    // 判断当前线程是否可以打印
                    System.out.println("0，" + printNum++);
                    Thread.sleep(1000);
                    semaphoreB.release();
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
                    semaphoreB.acquire();
                    // 判断当前线程是否可以打印
                    System.out.println("1，" + printNum++);
                    Thread.sleep(1000);
                    semaphoreC.release();
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
                    semaphoreC.acquire();
                    // 判断当前线程是否可以打印
                    System.out.println("2，" + printNum++);
                    Thread.sleep(1000);
                    semaphoreA.release();
                } catch (Exception e) {

                }
            }
        }
    }
}
