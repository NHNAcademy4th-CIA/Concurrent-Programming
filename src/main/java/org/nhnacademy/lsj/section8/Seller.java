package org.nhnacademy.lsj.section8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Seller extends Thread {

    private final Store store;

    private final List<Product> list = new ArrayList<>();

    public Seller(Store store, int number) {
        this.store = store;

        for (int i = 0; i < number; i++) {

            int cost = (int) (Math.random() * 10000 + 1000);
            list.add(new Product("Product " + (i + 1), cost, i));
        }


    }

    @Override
    public void run() { // 매장에 물건이 비지 않도록 채운다 . 1~10초 간격으로

        while (true) {

            int time = ThreadLocalRandom.current().nextInt(1, 10 + 1);

            try {
                Thread.sleep(time * 10); // 물건납품 기다림
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            int randomNumber = ThreadLocalRandom.current().nextInt(0, list.size());

            Product product = new Product(list.get(randomNumber).getName()
                    , list.get(randomNumber).getCost(), list.get(randomNumber).getIndex());

            store.buy(product);
            store.printProduct();

        }


    }
}