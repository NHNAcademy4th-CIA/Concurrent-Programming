package org.nhnacademy.minju.exercise8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 생산자는 매장에 물건이 비워지 않도록 채워둔다.
 * 물건은 1~10초 간격으로 채운다.
 * Thread내에서 난수 생성을 위해서는 ThreadLocalRandom.current().nextInt()를 사용
 */
public class Seller extends Thread {
    private Store store;
    private int itemCategoryCount;
    private Product[] itemCategory;
    private int ITEM_AMOUNT = 10;

    public Seller(Store store, int itemCategoryCount) {
        this.store = store;
        this.itemCategoryCount = itemCategoryCount;

        setItemCategory();
    }

    private void setItemCategory() {
        itemCategory = new Product[itemCategoryCount];
        for (int i = 0; i < itemCategoryCount; i++) {
            itemCategory[i] = (new Product("item" + i, ITEM_AMOUNT));
        }
        store.setItemList(itemCategory);
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!Thread.interrupted()) {
            store.buy(random.nextInt(store.getItemListSize()));

            try {
                sleep(ThreadLocalRandom.current().nextInt(100, 1_000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }
        }
    }
}