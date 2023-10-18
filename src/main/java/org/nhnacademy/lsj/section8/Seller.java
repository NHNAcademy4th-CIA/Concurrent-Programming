package org.nhnacademy.lsj.section8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 매장에 물건을 납품하는 생산자(Seller) .
 */
public class Seller extends Thread {

    private final Store store;

    private final List<Product> list = new ArrayList<>();

    /**
     * 생산자의 생성자.
     *
     * @param store  납품 받을 마트.
     * @param number 마트의 물건 품목 개수.
     */
    public Seller(Store store, int number) {
        this.store = store;

        for (int i = 0; i < number; i++) {

            int cost = (int) (Math.random() * 10000 + 1000);
            list.add(new Product("Product " + (i + 1), cost, i));
        }


    }

    @Override
    public void run() { // 매장에 물건이 비지 않도록 채운다 .

        while (!Thread.interrupted()) {

            int time = ThreadLocalRandom.current().nextInt(1, 10 + 1);

            try {
                Thread.sleep(time * 10); // 물건납품에 걸리는 시간.
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            int randomNumber = ThreadLocalRandom.current().nextInt(0, list.size());

            Product product = new Product(list.get(randomNumber).getName(), list.get(randomNumber).getCost(),
                    list.get(randomNumber).getIndex());
            // Product 랜덤하게 생성

            store.buy(product); // 마트에 물품 납품.
            store.printProduct(); // 마트에 물품 리스트 출력.

        }


    }
}