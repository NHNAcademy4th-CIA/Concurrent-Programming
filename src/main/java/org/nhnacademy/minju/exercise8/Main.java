package org.nhnacademy.minju.exercise8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("N개의 품목 : ");
        Store store = new Store();
        Seller seller = new Seller(store, scanner.nextInt());

        seller.start();

        for (int i = 0; ; i++) {
            Buyer buyer = new Buyer("Buyer " + i, store);
            buyer.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("terminated");
                Thread.currentThread().interrupt();
            }
        }
    }

}
