package org.nhnacademy.lsj.section7;

public class Buyer extends Thread {


    private final Store store;

    public Buyer(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {


        while (true) {

            store.enter();
            store.sell();
            store.exit();

        }


    }

}
