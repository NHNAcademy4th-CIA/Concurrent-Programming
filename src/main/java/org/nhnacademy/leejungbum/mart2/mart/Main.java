package org.nhnacademy.leejungbum.mart2.mart;

public class Main {
    public static void main(String[] args) {
        Store store = new Store(5);
        Buyer buyer[] = new Buyer[10];
        Seller seller = new Seller(store);
        seller.start();

        for(int i=0;i<5;i++)
        {
            buyer[i] = new Buyer("buyer"+i,store,5);
            buyer[i].start();
        }
    }
}
