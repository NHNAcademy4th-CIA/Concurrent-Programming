package org.nhnacademy.lsj.section7;

public class Main {


    public static void main(String[] args) {


        Store store = new Store();


        Seller[] sellers = new Seller[10];
        Buyer[] buyers = new Buyer[10];

        for (int i = 0; i < sellers.length; i++) {
            sellers[i] = new Seller(store);
            buyers[i] = new Buyer(i + " 번째 구매자", store);
        }


        for (int i = 0; i < sellers.length; i++) {
            sellers[i].start();
            buyers[i].start();
        }


    }

}
