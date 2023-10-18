package org.nhnacademy.leejungbum.mart;

import java.util.concurrent.ThreadLocalRandom;

public class Seller extends Thread {
    private Store store;

    public Seller(Store store) {
        this.store  = store;
    }

    @Override
    public void run() {
        while(!Thread.interrupted())  {
            try {
                store.sell();
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 10000));
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}