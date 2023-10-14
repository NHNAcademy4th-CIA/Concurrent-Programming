package org.nhnacademy.lsj.section8;

import java.util.ArrayList;
import java.util.List;

/**
 * 생산자와 소비자가 이용할 마트 class.
 */
public class Store {


    // custom으로 만든 세마포어.
    private final CustomSemaphore customSemaphore = new CustomSemaphore(10);
    private final List[] productList;


    /**
     * 마트의 생성자.
     *
     * @param totalProductCategoryNumber 최대 품목 개수 , array[] 안에 list가 있는 형태로 물품 관리.
     */
    public Store(int totalProductCategoryNumber) {
        productList = new List[totalProductCategoryNumber];

        for (int i = 0; i < totalProductCategoryNumber; i++) {
            List<Product> list = new ArrayList<>();
            productList[i] = list;
        }

    }


    /**
     * 마트에 있는 물품 모두 출력 , 마트의 물품을 모두 access 해야 하기 떄문에 , mutex이용.
     */
    public synchronized void printProduct() {

        for (int i = 0; i < productList.length; i++) {
            if (!productList[i].isEmpty()) {
                System.out.println("물품 : " + productList[i].get(0) + " 현재 재고 " + productList[i].size());
            }
        }

    }


    /**
     * 손님 입장.
     */
    public void enter() {

        try {
            customSemaphore.acquire(); // 한번에 10명만 들어올 수 있음
            Thread.sleep(500); // 들어와서는 0.5초 기다렸다 물건 사
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 손님 퇴장.
     */
    public void exit() {
        customSemaphore.release(); // 손님 나감
    }

    /**
     * Seller(생산자)가 물품 납임.
     *
     * @param product 물품.
     */
    public void buy(Product product) {

        int index = product.getIndex();

        try {
            Thread.sleep(500); // 매장에 물건 들어오는데 0.5초 걸림
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // 품목별로 매장이 다르기 떄문에 index이용 , mutex로 접근제어.
        synchronized (productList[index]) {
            productList[index].add(product);
            System.out.println("매장에 물건 입고 " + product);
            productList[index].notifyAll(); // 물건 입고됐으면 재고 없어서 기다리던 thread를 꺠워줌.
        }


    }

    /**
     * Buyer(소비자)가 물품 구임.
     *
     * @param index 소비자가 사용할 매장 번호.
     */
    public void sell(int index) {


        synchronized (productList[index]) { // 이용할 매장에 대한 mutex.

            while (productList[index].isEmpty()) {
                try {
                    productList[index].wait(); // 비어있다면 wait , 물건이 입고되면 notifyAll()로 꺨 수 있음.
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
