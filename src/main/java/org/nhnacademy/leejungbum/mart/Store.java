package org.nhnacademy.leejungbum.mart;

import java.util.concurrent.Semaphore;


public class Store {
    Semaphore semaphore;
    int boxCount;

    public Store() {
        semaphore = new Semaphore(5);
        boxCount = 0;
    }

    public void enter() throws InterruptedException {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 입장");
        } catch (InterruptedException e) {
            throw e;
        }
    }

    public void exit() {
        semaphore.release();
        System.out.println(Thread.currentThread().getName() + " 퇴장");
    }

    public synchronized void buy() {
        while(boxCount == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " 구매 대기");
                wait();
                Thread.sleep(100);
            } catch(InterruptedException ignore) {
                    Thread.interrupted();
            }
        }

        --boxCount;
        System.out.println("구매 완료, 제고 : " + boxCount);
        notify();
    }

    public synchronized void sell() {
        while(boxCount >= 10) {
            try {
                System.out.println("납품 대기 중입니다.");
                wait();
                Thread.sleep(100);
            } catch(InterruptedException ignore) {
                Thread.interrupted();

            }
        }

        ++boxCount;
        System.out.println("납품 완료. 제고 : " + boxCount);
        notifyAll();
    }
}
