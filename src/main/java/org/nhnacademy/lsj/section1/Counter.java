package org.nhnacademy.lsj.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Thread 클래스 확장.
 *
 * Thread 클래스 확장은 Java에서 지원해주는 Thread 클래스를 확장하여 새로운 클래스 구현을 말한다.
 *
 * 단일 스레드 환경에서의 여러 작업을 실행하여 문제점을 확인한다.
 *
 * Thread 클래스를 확장해 스레드로 동작하는 클래스를 만든다.
 *
 * Thread 클래스 확장을 통해 여러 작업을 동시해 실행해 확인한다.
 */

public class Counter {


    private static final Logger logger = LoggerFactory.getLogger(Counter.class);

    private String name;
    private int count;

    public Counter() {
        this.name = "Counter";
        this.count = 0;
    }

    private void increaseCount() {
        this.count++;
    }

    public void run() {

        while (!Thread.interrupted()) {
            increaseCount();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warn("{}", e.getMessage());
            }
            logger.info("{} : {}", this.name, this.count);
        }

    }


    public static void problem1() {

        Counter counter = new Counter();
        counter.run();
    }

    public static void problem2() {
        Counter counter = new Counter();
        Counter counter2 = new Counter();

        counter.run(); // count 하나만 출력 됨 , 왜?? multi thread가 아니라 , single thread니까.
        counter2.run();
    }

    public static void problem3() {
        CounterThread counterThread1 = new CounterThread("CounterThread1");
        CounterThread counterThread2 = new CounterThread("CounterThread2");

        counterThread1.start(); // 여기서 부터 multi thread를 사용하는 것임
        counterThread2.start();
    }

    public static void problem4() {

        Counter counter = new Counter();
        CounterThread counterThread = new CounterThread("CounterThread");

        counterThread.start(); // multi thread 이용
        counter.run(); // 기존에 돌아가던 thread가 실행시킴

    }

    public static void main(String[] args) {

        //problem1();
        //problem2();
        //problem3();
        //problem4();

    }


}


