package com.xiaour.spring.boot.base.ThreeThreadsAlternatelyPrint;

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
public class Solution_sync {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA(0);
        ThreadA threadB = new ThreadA(1);
        ThreadA threadC = new ThreadA(2);

        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();

    }
    public static Object obj = new Object();

    public static int numSum = 0;

    public static int printNum = 0;

    public static class ThreadA implements Runnable {
        private int threadName;

        public ThreadA(int threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 三个线程只有一个线程可以抢到锁
                    synchronized (obj) {
                        // 判断当前线程是否可以打印
                        if (numSum % 3 == threadName) {
                            System.out.println(threadName + "，" + printNum++);
                            numSum++;
                            Thread.sleep(1000);
                            // 打印之后通知其他线程启动，并且自己退出锁
                            obj.notifyAll();
                        } else {
                            // 不是自己的回合，那就释放锁，休眠
                            obj.wait();
                        }
                    }
                } catch (Exception e) {

                }
            }
        }

        /* 第二种方案，直接通过把打印线程的锁住，然后通过numSum来要求某一个线程执行,这种情况就是互相竞争会比较多
        @Override
        public void run() {
            while (true) {
                try {
                    // 三个线程只有一个线程可以抢到锁
                    synchronized (obj) {
                        // 判断当前线程是否可以打印
                        if (numSum % 3 == threadName) {
                            System.out.println(threadName + "，" + printNum++);
                            numSum++;
                            Thread.sleep(1000);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }*/


        /*第三种方案，直接通过把打印线程的锁住，然后通过numSum来要求某一个线程执行,这种情况就是互相竞争会比较多
        @Override
        public void run() {
            while (true) {
                try {
                    // 三个线程只有一个线程可以抢到锁
                    lock.lock();
                    // 判断当前线程是否可以打印
                    if (numSum % 3 == threadName) {
                        System.out.println(threadName + "，" + printNum++);
                        numSum++;
                        Thread.sleep(1000);
                    }
                    lock.unlock();
                } catch (Exception e) {

                }
            }
        }*/
    }
}
