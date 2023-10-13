package org.nhnacademy.lsj.section7;

import java.util.LinkedList;
import java.util.Queue;

public class Store {


    public Queue<Product> queue = new LinkedList<>();


    public int customerNumber;

    public Store() {
        customerNumber = 0;
    }

    private void printProduct() {

        System.out.println("매장의 물건 리스트");
        for (Product p : queue) {
            System.out.println(p);
        }
    }


    public synchronized void enter() {

        System.out.println("매장 들어와 지금 손님수 " + this.customerNumber);
        while (this.customerNumber == 5) {
            try {
                System.out.println("손님 기다리는 중 ");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        customerNumber++;
    }

    public void exit() {
        System.out.println("손님 Exit 현재 손님 수 " + this.customerNumber);
        customerNumber--;
    }

    public synchronized void buy(Product product) {

        while (this.queue.size() == 10) {
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

    public synchronized void sell() {

        while (this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        Product product = queue.poll();
        System.out.println("물건 판매 " + product);
        printProduct();
        notifyAll();

    }


}
