package org.nhnacademy.leejungbum.mart;

public class main {
    public static void main(String[] args) {
        Store store = new Store();
        Buyer buyer[] = new Buyer[5];
        for(int i=0;i<5;i++)
        {
            buyer[i] = new Buyer("buyer"+i,store);
            buyer[i].start();
        }
        Seller seller = new Seller(store);
        seller.start();
    }
}
