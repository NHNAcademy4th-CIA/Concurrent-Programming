package org.nhnacademy.leejungbum.mart2.mart;

import java.util.concurrent.ThreadLocalRandom;

public class Buyer extends Thread {
    private Store store;
    private int number;
    public Buyer(String name, Store store, int number) {
        super(name);
        this.store = store;
        this.number= number;
    }

    @Override
    public void run() {
        while(!Thread.interrupted())  {
            try {
                store.enter();
                int index = ThreadLocalRandom.current().nextInt(0, number);
                store.buy(index);

                store.exit();

                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 10000));
            } catch(InterruptedException ignore) {
                System.out.println("buy");
                Thread.currentThread().interrupt();
            }
        }
    }
}
