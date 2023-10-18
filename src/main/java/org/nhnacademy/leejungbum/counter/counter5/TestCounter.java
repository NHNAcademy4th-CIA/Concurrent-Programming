package org.nhnacademy.leejungbum.counter.counter5;

import org.nhnacademy.leejungbum.counter.counter2.Counter;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter("Counter");
        CounterThread counterThread1 = new CounterThread("CounterThread1");
        CounterThread counterThread2 = new CounterThread("CounterThread2");
        counterThread1.start();
        counter.run();

        counterThread2.start();
    }
}

