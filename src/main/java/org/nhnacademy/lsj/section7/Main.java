package org.nhnacademy.lsj.section7;

/**
 * 생산자-소비자 솔루션
 * 생산자와 소비자가 거래하는 생산자-소비자 솔루션을 구성해 봅니다.
 */
public class Main {


    /**
     * 마트 하나 , 마트에 물건 납품하는 Seller(생산자) 1 , 물건 사갈 Buyer(소비자) 5 .
     *
     * @param args command line.
     */
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
