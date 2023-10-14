package org.nhnacademy.lsj.section7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 습 8-1. 마트내에 위치한 매장(Store)을 정의하라.
 * 매장은 물건을 납품 받아서 판매한다.
 * 매장에는 최대 10개의 물건만 전시할 수 있다.
 * 매장은 최대 5명까지만 동시 입장 가능하다.
 * 매장에서 물건 구매는 동시에 1명만 가능하다.
 * 매장에서 물건 판매 후 빈 공간에 생기면 생산자에게 알려 준다.
 * 매장에서 물건 납품은 동시에 1명만 가능하다.
 * 매장에서 물건이 들어오면 소비자에게 알려 준다.
 */
public class Store {


    private Queue<Product> queue = new LinkedList<>();
    private int customerNumber;

    public Store() {
        customerNumber = 0;
    }

    private void printProduct() {

        System.out.println("매장의 물건 리스트");
        for (Product p : queue) {
            System.out.println(p);
        }
    }


    /**
     * 손님이 마트에 들어옴 . 최대 5명까지 들어 올 수 있음.
     * 5명이 들어와 있으면 wait하게 됨.
     */
    public synchronized void enter() {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("매장의 손님수 " + this.customerNumber);
        while (this.customerNumber == 5) {
            try {
                System.out.println("입장 기다리는 중 ");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        customerNumber++;
    }

    /**
     * 손님이 마트에서 나감.
     */
    public void exit() {
        System.out.println("손님 Exit 현재 손님 수 " + this.customerNumber);
        customerNumber--;
    }

    /**
     * 마트에서 물건을  Seller (생산자) 로 부터 납품받음.
     *
     * @param product 납품받을 물건.
     */
    public synchronized void buy(Product product) {

        while (this.queue.size() == 10) { // 최대 10개만 전시가능.
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("매장에 물건 입고 " + product);
        queue.add(product);
        printProduct();
        notifyAll();
    }

    /**
     * 소비자 Buyer에게 물건 판매. 판매할 물건이 없다면 wait하게 됨.
     */
    public synchronized void sell() {

        while (this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Product product = queue.poll();
        System.out.println("물건 판매 " + product); // 손님이 매장에서 물건 사감.
        printProduct();
        notifyAll();

    }


}
