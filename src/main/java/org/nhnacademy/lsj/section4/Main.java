package org.nhnacademy.lsj.section4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 스레드 동기화
 * Mutex , synchronized , Lock , Semaphore 를 연습하는 class.
 */
public class Main {

    private static int countNumber = 0;

    /**
     * multi thread환경에서 mutex를 통해 보호받는 변수와 , 그렇지 않은 변수를 확인한다.
     * 또한 mutex사용시 시간이 오래 걸리는 단점을 확인해 본다.
     */
    public static void problem1() {
        Counter counter = new Counter();
        int numberOfIterations = 100000000;

        CountAgent agent1 = new CountAgent(counter, numberOfIterations, true);
        CountAgent agent2 = new CountAgent(counter, numberOfIterations, false);


        agent1.start();
        agent2.start();

        long start = System.currentTimeMillis();

        try {
            agent1.join();
            agent2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Count : " + counter.getCounter());
        System.out.println("Another Count : " + counter.getAnotherCount());
        // 동기화 안돼있어서 another count는 0이 나오질 않음.

        long end = System.currentTimeMillis();

        System.out.println("Synchronized Time : " + (end - start));


        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfIterations; i++) {
                    countNumber++;
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfIterations; i++) {
                    countNumber--;
                }
            }
        };


        start = System.currentTimeMillis();
        Thread thread = new Thread(r);
        Thread thread2 = new Thread(r2);

        thread.start();
        thread2.start();
        end = System.currentTimeMillis();

        System.out.println("Count : " + countNumber);

        System.out.println("aSynchronized Time : " + (end - start)); // Synchronized 없는게 확실히 더 빠름
        // 하지만 값은 부정확함.

    }


    /**
     * 연습 5-4-1. 두개의 스레드가 두개의 리소스를 공유하면서 하나의 리소스 획득 후 다른 리소스를 기다리면서 발생할 수 있는 교착 상태를 만들어 보자.
     */
    public static void problem2() {
        Object object = new Object();
        Object object2 = new Object();

        // 각자 object , object2 에 대한 lock을 가짐 , 따라서 deadlock 발생.

        Thread task1 = new Thread(() -> {

            synchronized (object) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                synchronized (object2) {
                    System.out.println("Thread1 " + object2);
                }
                object.notify();
            }

            System.out.println("여기까지 안와");

        });


        Thread task2 = new Thread(() -> {
            synchronized (object2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                synchronized (object) {
                    System.out.println("Thread2 " + object);
                }

                object2.notify();
            }

            System.out.println("여기까지 안와");

        });

        task1.start();
        task2.start();
    }


    /**
     * 연습 5-4-2. 두개의 스레드가 하나의 리소스를 공유 하더라도 교착 상태가 발생할 수 있다.
     * taks2가 object에 대한 lock을 가진채로 종료돼버려 , task1은 계속해서 waiting 하는 상태.
     * 즉 deadlock 상태가 되버림.
     */
    public static void problem3() {
        Object object = new Object();

        Lock lock = new ReentrantLock();

        Thread task1 = new Thread(() -> {

            while (!Thread.interrupted()) {
                try {
                    lock.lockInterruptibly();
                    System.out.println("Task1 : " + object);
                    lock.unlock();
                } catch (InterruptedException e) {
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
                    Thread.sleep(1000);
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


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        task1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Task1 : " + task1.getState() + ", Task2 : " + task2.getState());
            if (i == 2) {
                task2.interrupt(); // task2 중간에 죽임.
            }
        }

        try {
            task2.join();
        } catch (InterruptedException e) {
            System.out.println("에러");
        }

        task1.interrupt();

        System.out.println("테스트 종료");
    }

    /**
     * 연습 5-5. 여러개의 스레드가 제한된 수의 공유 자원을 이용하려 한다. 관련 예제를 만들어 본다.
     * 옷을 팔고 있는 가게에 10명의 손님이 있다.
     * 손님은 옷을 고른 후 탈의실에서 입어 보려 한다.
     * 하지만, 탈의실은 5개만 있다.
     * 세마포어를 이용해 탈의실이 5개 있음을 구현함.
     */
    public static void problem4() {
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

    public static void main(String[] args) {

        //problem1();
        //problem2();
        //problem3();
        //problem4();

    }

}
