package org.nhnacademy.lsj.section7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 연습 8-2. 매장에 물건을 납품하는 생산자(Seller)을 정의하라.
 * 생산자는 매장에 물건이 비워지 않도록 채워둔다.
 * 물건은 일정한 간격으로 채운다.
 */
public class Seller extends Thread {

    private Store store;

    private List<Product> list = new ArrayList<>();

    /**
     * 마트에 물건 납품하는 생산자 , 정해진 품목을 마트에 납품함.
     *
     * @param store 물건 납품할 마트 .
     */
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
    public void run() { // 매장에 물건이 비지 않도록 채운다 .

        while (true) {


            try {
                Thread.sleep(5); // 물건납품에 걸리는 시간.
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            int randomNumber = ThreadLocalRandom.current().nextInt(0, list.size());

            Product product = list.get(randomNumber);

            store.buy(product); // 마트에 물건 납품함.

        }


    }
}
