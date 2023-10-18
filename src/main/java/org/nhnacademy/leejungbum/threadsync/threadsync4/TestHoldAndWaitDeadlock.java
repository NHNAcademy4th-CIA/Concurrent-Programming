package org.nhnacademy.leejungbum.threadsync.threadsync4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestHoldAndWaitDeadlock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread task1 = new Thread(() -> {
            lock.lock();
            System.out.println("Task1:lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread task2 = new Thread(() -> {
            lock.lock();
            System.out.println("Task2:lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        task1.start();
        task2.start();

        try {
            for(int i = 0 ; i < 10 ; i++) {
                System.out.println("Task1 : " + task1.getState() + ", Task2 : " + task2.getState());
                if (i == 2) {
                    task2.interrupt();
                }
                Thread.sleep(1000);
            }
            task1.join();
            task2.join();
        } catch(InterruptedException ignore) {
        }

        System.out.println("테스트 종료");
    }
}