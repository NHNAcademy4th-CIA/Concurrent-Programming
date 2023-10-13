package org.nhnacademy.minju.exercise4;

import java.util.concurrent.Semaphore;

/**
 * Semaphore는 다수의 스레드가 동시에 접근하는 리소스의 수를 제어하거나, 특정 작업에 대한 허용 가능한 최대 스레드 수를 제어하는 데 사용된다.
 * Semaphore에서 허용 가능한 수를 초과할 경우, 해당 스레드는 semaphore에서 허용 권한이 생길때까지 기다린다.
 * Semaphore(1)은 Lock과 동일하게 동작한다.
 */
public class TestClothingStore {
    public static void main(String[] args) {
        Semaphore dressrooms = new Semaphore(5);
        Thread[] customers = new Thread[10];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(() -> {
                try {
                    dressrooms.acquire();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(Thread.currentThread().getName() + "손님 탈의 완료");
                dressrooms.release();
            });

        }
        for (int i = 0; i < customers.length; i++) {
            customers[i].start();
        }


        System.out.println("탈의 완료");
    }
}
