package org.nhnacademy.lsj.section4;

/**
 * 연습 5-1. Counter 클래스.
 * Counter 클래스는 increment 함수를 가지고, increment 함수가 불릴때 마다 숫자를 중가 시킨다.
 * Counter 클래스는 decrement함수를 가지고, decrement함수가 불릴때마다 숫자를 감소 시킨다.
 * Counter 클래스는 증가되거나 감소된 값을 반환할 수 있다.
 */
public class Counter {


    private long count;

    private long anotherCount;


    /**
     * 연습 5-2-1. 자바의 동기화 기능인 synchronized를 이용해 상호 배제를 수행하라.
     */
    public synchronized void increasement() {
        this.count++;
    }

    /**
     * 연습 5-2-1. 자바의 동기화 기능인 synchronized를 이용해 상호 배제를 수행하라.
     */
    public synchronized void decreasement() {
        this.count--;
    }


    /**
     * 연습 5-2-2. 자바의 동기화 기능인 synchronized를 이용해 Counter 클래스의 count에 대해서만 상호 배제를 수행하라.
     */
    public void increasementAnother() {
        this.anotherCount++;
    }

    /**
     * 연습 5-2-2. 자바의 동기화 기능인 synchronized를 이용해 Counter 클래스의 count에 대해서만 상호 배제를 수행하라.
     */
    public void decreasementAnother() {
        this.anotherCount--;
    }

    public long getCounter() {
        return this.count;
    }

    public long getAnotherCount() {
        return this.anotherCount;
    }

}
