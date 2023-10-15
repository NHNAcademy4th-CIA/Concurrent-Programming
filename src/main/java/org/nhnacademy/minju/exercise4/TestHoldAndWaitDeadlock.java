package org.nhnacademy.minju.exercise4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 스레드 2에서 리소스를 사용하던 중 문제가 발생하여 예외 처리 상황이 발생할 경우,
 * 이에 대하 잘못된 처리로 스레드 1은 교착 상태에 빠질 수 있다.
 * void lock() – 가능한 경우 잠금을 획득한다. 잠금할 수 없다면 잠금이 해제될 때까지 스레드가 차단된다.
 */
public class TestHoldAndWaitDeadlock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread task1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                lock.lock();
                System.out.println("lock acquired");
            }
        });

        Thread task2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                lock.lock();
            }
        });

        task1.start();
        task2.start();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task1 : " + task1.getState() + ", Task2 : " + task2.getState());
                if (i == 2) {
                    task2.interrupt();
                }
                Thread.sleep(1000);
            }
            task1.join();
            task2.join();
        } catch (InterruptedException ignore) {
        }

        System.out.println("테스트 종료");
    }
}