package org.nhnacademy.lsj.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runnable 인터페이스 구현.
 * 스레드 생성은 앞서 소개한 클래스 상속외에 Runnable 인터페이스를 통해서도 가능하다.
 * Thread 클래스의 상속도를 보면 Thread 클래스도 Runnable 인터페이스를 구현하여 정의되었음을 알 수 있다.
 * Runnable 인터페이스를 이용한 스레드 클래스 생성을 확인한다.
 */
public class CounterRunnable implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(CounterRunnable.class);

    private String name;
    private int count;

    private Thread thread;

    public CounterRunnable(String name) {
        this.name = name;
    }

    public void start() {
        thread = new Thread(this);
        this.thread.start();
    }

    /**
     * 1초마다 count 출력.
     */
    @Override
    public void run() {

        while (!Thread.interrupted()) {
            this.count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warn("{}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            logger.info("{} : {}", this.name, this.count);

        }
    }


    /**
     * 연습 2-1. CounterRunnable 클래스를 만들어 동작 확인하기.
     */
    public static void problem1() { // 기존과 같은 결과
        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable");

        Thread thread = new Thread(counterRunnable);
        thread.start();

    }

    /**
     * 연습 2-2. CounterRunnable 클래스의 인스턴스를 동시에 2개 실행해 확인하기.
     */
    public static void problem2() {

        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable1");
        CounterRunnable counterRunnable2 = new CounterRunnable("CounterRunnable2");

        Thread thread = new Thread(counterRunnable);
        Thread thread2 = new Thread(counterRunnable2);
        thread.start(); // multi thread 잘 작동함.
        thread2.start();


    }

    /**
     * 연습 2-3. 같은 공유자원을 쓰는 경우 count 확인 .
     */
    public static void problem3() {

        // 만약 같은 CounterRunnable 을 갖고 실행시킨다면??

        CounterRunnable counterRunnableDulpicated = new CounterRunnable("counterRunnableDulpicated");
        Thread threadDulpicated = new Thread(counterRunnableDulpicated);
        Thread threadDulpicated2 = new Thread(counterRunnableDulpicated);

        threadDulpicated.start(); // 이 경우에는 공유자원이 같기 떄문에 , 1씩 증가하지 않음
        threadDulpicated2.start();

    }


    public static void main(String[] args) {


        //problem1();
        //problem2();
        //problem3();


    }

}
