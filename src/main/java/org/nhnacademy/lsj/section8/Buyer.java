package org.nhnacademy.lsj.section8;


import java.util.concurrent.ThreadLocalRandom;

public class Buyer extends Thread {


    private final Store store;

    private final int number;

    public Buyer(String name, Store store, int number) {
        super(name);
        this.store = store;
        this.number = number;
    }


    @Override
    public void run() {

        while (true) {
            store.enter();
            int index = ThreadLocalRandom.current().nextInt(0, number);
            store.sell(index);
            store.exit();
        }


    }

}


