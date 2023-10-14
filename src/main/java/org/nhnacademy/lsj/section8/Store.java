package org.nhnacademy.lsj.section8;

import java.util.ArrayList;
import java.util.List;

public class Store {


    private final CustomSemaphore customSemaphore = new CustomSemaphore(10);
    private final List[] productList;


    public Store(int totalProductCategoryNumber) {
        productList = new List[totalProductCategoryNumber];

        for (int i = 0; i < totalProductCategoryNumber; i++) {
            List<Product> list = new ArrayList<>();
            productList[i] = list;
        }

    }


    public synchronized void printProduct() {

        for (int i = 0; i < productList.length; i++) {
            for (int j = 0; j < productList[i].size(); j++) {
                System.out.println(productList[i].get(j));
            }
        }

    }


    public void enter() {

        try {
            customSemaphore.acquire(); // 한번에 10명만 들어올 수 있음
            Thread.sleep(500); // 들어와서는 0.5초 기다렸다 물건 사
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exit() {
        customSemaphore.release(); // 손님 나감
    }

    public void buy(Product product) {

        int index = product.getIndex();

        try {
            Thread.sleep(500); // 매장에 물건 들어오는데 0.5초 걸림
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        synchronized (productList[index]) {
            productList[index].add(product);
            System.out.println("매장에 물건 입고 " + product);
            productList[index].notifyAll();
        }


    }

    public void sell(int index) {


        synchronized (productList[index]) {

            while (productList[index].isEmpty()) {
                try {
                    productList[index].wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }


            System.out.println("물건 판매 완료 " + productList[index].get(0));
            productList[index].remove(0);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }


    }


}
