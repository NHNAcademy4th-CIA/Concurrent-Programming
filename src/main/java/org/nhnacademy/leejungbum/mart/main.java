package org.nhnacademy.leejungbum.mart;

public class main {
    public static void main(String[] args) {
        Store store = new Store();
        Buyer buyer = new Buyer("asd",store);
        Seller seller = new Seller(store);
        seller.start();
        buyer.start();
    }
}
