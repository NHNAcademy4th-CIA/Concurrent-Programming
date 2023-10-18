package org.nhnacademy.leejungbum.runnable.runnable1;

import org.nhnacademy.leejungbum.counter.counter2.Counter;

public class TestCounter {
    public static void main(String[] args) {
        CounterRunnable counterRunnable1 = new CounterRunnable("CounterRunnable1");
        CounterRunnable counterRunnable2 = new CounterRunnable("CounterRunnable2");

        Thread thread = new Thread(counterRunnable1);

//        counterRunnable1.run();
        thread.start();
        counterRunnable2.run();
    }
}