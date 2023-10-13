package org.nhnacademy.lsj.section4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 두개의 스레드가 하나의 리소스를 공유 하더라도 교착 상태가 발생할 수 있다.
 */

public class Test2 {

    // task2가 object lock 걸고 죽어버림 , task1는 계속 lock 기다리다 프로그램 종료

    public static void main(String[] args) {


        Object object = new Object();

        Lock lock = new ReentrantLock();

        Thread task1 = new Thread(() -> {

            while (!Thread.interrupted()) {
                try {
                    lock.lockInterruptibly();
                    System.out.println("Task1 : " + object);
                    lock.unlock();
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                    Thread.currentThread().interrupt();
                }

            }

            System.out.println("끝났음 !!");

        });

        Thread task2 = new Thread(() -> {

            while (!Thread.interrupted()) {
                lock.lock();
                System.out.println("object 점유중 " + object);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    break;
                }

                System.out.println("object 점유 해제");
                lock.unlock();

            }
            System.out.println("Task2 종료");

        });





        task2.start();
        task1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Task1 : " + task1.getState() + ", Task2 : " + task2.getState());
            if (i == 2) {
                task2.interrupt();
            }
        }


        try{
            task2.join();
        } catch (InterruptedException e) {
            System.out.println("에러");
        }

        task1.interrupt();

        System.out.println("테스트 종료");
    }

}
