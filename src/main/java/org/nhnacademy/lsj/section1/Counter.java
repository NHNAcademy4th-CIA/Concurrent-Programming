package org.nhnacademy.lsj.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread 클래스 확장.
 * Thread 클래스 확장은 Java에서 지원해주는 Thread 클래스를 확장하여 새로운 클래스 구현을 말한다.
 * 단일 스레드 환경에서의 여러 작업을 실행하여 문제점을 확인한다.
 * Thread 클래스를 확장해 스레드로 동작하는 클래스를 만든다.
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

    /**
     * 1초마다 count 출력하기.
     */
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


    /**
     * 연습 1-1. Counter 클래스를 만들어 동작 확인하기.
     */
    public static void problem1() {

        Counter counter = new Counter();
        counter.run();
    }

    /**
     * 연습 1-2. Counter클래스인 인스턴스를 동시에 2개 실행해 확인하기.
     */
    public static void problem2() {
        Counter counter = new Counter();
        Counter counter2 = new Counter();

        counter.run(); // count 하나만 출력 됨 , 왜?? 일반 method와 같이 해당 코드블럭으로 넘어가서 실행되기 떄문
        counter2.run();
    }

    /**
     * 연습 1-3. CounterThread 클래스를 만들어 동작 확인하기.
     */
    public static void problem3() {
        CounterThread counterThread1 = new CounterThread("CounterThread1");

        counterThread1.start(); // 정상적으로 실행 잘 됨 , CounterThread는 Thread 를 extends받음
    }

    /**
     * 연습 1-4. CounterThread 클래스의 인스턴스를 동시에 2개 실행해 확인하기.
     */
    public static void problem4() {

        CounterThread counterThread1 = new CounterThread("CounterThread1");
        CounterThread counterThread2 = new CounterThread("CounterThread2");

        counterThread1.start(); // 여기서 부터 multi thread를 사용하는 것임
        counterThread2.start(); // 동시에 출력 된다

    }

    /**
     * 연습 1-5. Counter 클래스의 인스턴스와 CounterThread 클래스의 인스턴스를 동시에 실행해 확인하기.
     */
    public static void problem5() {
        CounterThread counterThread1 = new CounterThread("CounterThread1");
        Counter counter = new Counter();

        counterThread1.start(); // 이것 또한 multi thread , counter와 순서 바뀌면 동시출력 안됨.
        counter.run();

    }

    public static void main(String[] args) {

//        problem1();
//        problem2();
//        problem3();
//        problem4();
//        problem5();


    }


}


