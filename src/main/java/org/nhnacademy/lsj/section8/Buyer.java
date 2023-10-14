package org.nhnacademy.lsj.section8;


import java.util.concurrent.ThreadLocalRandom;

/**
 * 마트에서 물건 사갈 소비자 class .
 */
public class Buyer extends Thread {
    private final Store store;
    private final int number;

    /**
     * 생산자 .
     *
     * @param name   소비자 이름.
     * @param store  이용할 마트.
     * @param number 마트의 최대 품목 수.
     */
    public Buyer(String name, Store store, int number) {
        super(name);
        this.store = store;
        this.number = number;
    }


    @Override
    public void run() {

        while (true) {
            store.enter(); // 마트 들어가
            int index = ThreadLocalRandom.current().nextInt(0, number); // 난수 생성
            store.sell(index); // 마트에서 물건 구입
            store.exit(); // 마트 나와
        }


    }

}


