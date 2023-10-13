package org.nhnacademy.lsj.section4;

import java.util.concurrent.Semaphore;

public class TestClothingStore {

    static Semaphore dressrooms = new Semaphore(5);


    public static void main(String[] args) {
        Thread[] customers = new Thread[10];



        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new Cloth());
        }

        for (int i = 0; i < customers.length; i++) {
            customers[i].start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }

}

class Cloth implements Runnable {


    @Override
    public void run() {
        try {

            TestClothingStore.dressrooms.acquire();
            System.out.println("옷 입기");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            TestClothingStore.dressrooms.release();
            System.out.println("옷 입기 종료 ! ");
        }

    }

}
