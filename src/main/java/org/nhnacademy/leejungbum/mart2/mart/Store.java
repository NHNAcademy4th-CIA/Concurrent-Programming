package org.nhnacademy.leejungbum.mart2.mart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Store {
    Semaphore semaphore;
    int max;
    List<Integer> goods;

    public Store(int max) {
        semaphore = new Semaphore(5);
        goods = new ArrayList<>();
        this.max = max;
        for (int i = 0; i < 5; i++) {
            goods.add(max);
        }
    }

    public void enter() throws InterruptedException {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 입장");
        } catch (InterruptedException e) {
            System.out.println("입장중 오류가 발생하였습니다");
        }
    }

    public void exit() {
        semaphore.release();
        System.out.println(Thread.currentThread().getName() + " 퇴장");
    }

    public void buy(int i) {
        synchronized (goods) {
            while (goods.get(i) == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 구매 대기");
                    goods.wait();
                    Thread.sleep(100);
                } catch (InterruptedException ignore) {
                    Thread.interrupted();
                }
            }
            int tmp = goods.get(i) - 1;
            System.out.println(i + " 구매 완료, 제고 : " + tmp);
            goods.set(i, tmp);

            goods.notifyAll();
        }
    }

    public void sell() {
        int i = ThreadLocalRandom.current().nextInt(0, max);
        synchronized (goods) {

            while (goods.get(i) >= max) {
                try {
                    System.out.println("납품 대기 중입니다.");
                    goods.wait();
                    Thread.sleep(100);
                } catch (InterruptedException ignore) {
                    Thread.currentThread().interrupt();
                }
            }
            int tmp = goods.get(i) + 1;
            goods.set(i, tmp);
            System.out.println(i + " 납품 완료. 제고 : " + tmp);
            goods.notifyAll();
        }
    }
}
