package org.nhnacademy.lsj.section8;

import java.util.Scanner;

/**
 * 생산자-소비자 솔루션을 수정하라.
 * 문제 1.
 * 마트에서는 N개의 품목 매장이 있다.
 * 생산자는 N개의 품목을 납품할 수 있다.
 * 마트에서는 생산자가 품목을 납품하기 전까지는 어떤 품목인지 알 수 없다.
 * 소비자는 품목별로 매장을 이용할 수 있다. 즉, 여러 사람이 각기 다른 품목을 구매할 경우 동시 구매가 가능하다.
 * 문제 2.
 * 프로그램에서 사용되는 세마포어를 구현하여 적용하라.
 */
public class Main {


    private static final Scanner sc = new Scanner(System.in);

    /**
     * Store(마트) 1 , Buyer(소비자) 10 , Seller(생산자)1 .
     *
     * @param args Command Line.
     */
    public static void main(String[] args) {


        System.out.println("품목의 개수를 입력해주세요");

        int N = sc.nextInt(); // 물건 품목 개수

        Store store = new Store(N);
        Seller seller = new Seller(store, N);


        Buyer buyers[] = new Buyer[10]; // 손님 수

        for (int i = 0; i < buyers.length; i++) {
            buyers[i] = new Buyer((i + 1) + " 번째 소비자 ", store, N);
        }


        seller.start();


        try {
            Thread.sleep(4000); // 4초 기다린 후에 손님들이 입장함.
        } catch (InterruptedException e) {

        }

        for (int i = 0; i < buyers.length; i++) {
            buyers[i].start();
        }


    }


}
