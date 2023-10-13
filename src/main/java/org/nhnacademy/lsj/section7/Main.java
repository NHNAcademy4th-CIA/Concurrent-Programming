package org.nhnacademy.lsj.section7;

public class Main {


    public static void main(String[] args) {


        Store store = new Store();


        Seller seller = new Seller(store);

        Buyer[] buyers = new Buyer[5];

        seller.start();
        for (int i = 0; i < buyers.length; i++) {
            buyers[i] = new Buyer((i + 1) + " 번째 구매자", store);
        }


        for (int i = 0; i < buyers.length; i++) {
            buyers[i].start();
        }


    }

}
