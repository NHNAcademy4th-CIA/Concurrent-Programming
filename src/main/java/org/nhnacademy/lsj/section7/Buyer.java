package org.nhnacademy.lsj.section7;

/**
 * 마트에서 물건 사갈 소비자 class .
 */
public class Buyer extends Thread {


    private final Store store;

    public Buyer(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {


        while (true) {

            store.enter(); // 마트에 들어가
            store.sell(); // 마트에서 물건 사
            store.exit(); // 마트에서 나와

        }


    }

}
