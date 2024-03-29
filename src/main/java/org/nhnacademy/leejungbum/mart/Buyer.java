package org.nhnacademy.leejungbum.mart;

import java.util.concurrent.ThreadLocalRandom;

public class Buyer extends Thread {
    private Store store;

    public Buyer(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        while(!Thread.interrupted())  {
            try {
                store.enter();
                store.buy();
                store.exit();

                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 10000));
            } catch(InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
