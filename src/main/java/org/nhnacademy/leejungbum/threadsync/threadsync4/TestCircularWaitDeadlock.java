package org.nhnacademy.leejungbum.threadsync.threadsync4;

public class TestCircularWaitDeadlock {
    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread task1 = new Thread(() -> {
            synchronized (resource1) {
                try {
                    Thread.sleep(100);
                    resource1.wait();
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                synchronized (resource2) {
                    resource2.notify();
                }
            }
        });

        Thread task2 = new Thread(() -> {
            synchronized (resource2) {
                try {
                    Thread.sleep(100);
                    resource2.wait();
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                synchronized (resource1) {
                    resource1.notify();
                }
            }
        });

        task1.start();
        task2.start();
    }
}