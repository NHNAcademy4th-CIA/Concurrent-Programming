package org.nhnacademy.minju.exercise8;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 생산자는 매장에 물건이 비워지 않도록 채워둔다.
 * 물건은 1~10초 간격으로 채운다.
 * Thread내에서 난수 생성을 위해서는 ThreadLocalRandom.current().nextInt()를 사용
 */
public class Seller extends Thread {
    Store store;

    public Seller(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            store.sell();
            try {
                sleep(ThreadLocalRandom.current().nextInt(1_000, 10_000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }
        }
    }
}