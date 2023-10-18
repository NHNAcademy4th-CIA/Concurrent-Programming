package org.nhnacademy.leejungbum.threadsync.threadsync5;

import java.util.Timer;
import java.util.concurrent.Semaphore;

public class TestClothingStore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore dressrooms = new Semaphore(5);
        Customers [] customers = new Customers[10] ;

        for(int i = 0 ; i < customers.length ; i++) {
            dressrooms.acquire();
                                 customers[i].start();
            dressrooms.release();
        }
    }
    public static class Customers extends Thread{
        public Customers(String name){
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName()+"이 상용중");
            try {
                System.out.println("쉬는중");
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("쉬는시간 끝");
        }
    }
}
