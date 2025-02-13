package com.xiaour.spring.boot;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;

/**
 * @author rtw
 * @since 2025/1/14
 */
public class synClass {
    public boolean useable = true;

    public synchronized void work(int i) throws InterruptedException {
        while (useable) {
            wait();
        }
        System.out.println("work" + "_" + i);
        useable = true;
        notify();
    }

    public synchronized void workV2(int i) throws InterruptedException {
        while (!useable) {
            wait();
        }
        System.out.println("workV2" + "_" + i);
        useable = false;
        notify();
    }


    public static void main(String[] args) throws InterruptedException {
        synClass synClass = new synClass();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            Thread thread = new Thread(() -> {
                try {
                    synClass.work(j);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread thread2 = new Thread(() -> {
                try {
                    synClass.workV2(j);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            thread2.start();
        }

    }
}
