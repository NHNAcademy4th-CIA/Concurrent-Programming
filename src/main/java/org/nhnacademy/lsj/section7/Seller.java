package org.nhnacademy.lsj.section7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Seller extends Thread {

    private Store store;

    private List<Product> list = new ArrayList<>();

    public Seller(Store store) {
        this.store = store;

        list.add(new Product("사과", 5000));
        list.add(new Product("배추", 7000));
        list.add(new Product("돼지고기", 10000));
        list.add(new Product("소고기", 20000));
        list.add(new Product("두리안", 8000));
        list.add(new Product("김치", 6000));
    }

    @Override
    public void run() { // 매장에 물건이 비지 않도록 채운다 . 1~10초 간격으로

        while (true) {

            int time = ThreadLocalRandom.current().nextInt(1, 10 + 1);

            try {
                Thread.sleep(time * 500); // 물건납품 기다림
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            int randomNumber = ThreadLocalRandom.current().nextInt(0, list.size());

            Product product = list.get(randomNumber);

            store.buy(product);

        }


    }
}
