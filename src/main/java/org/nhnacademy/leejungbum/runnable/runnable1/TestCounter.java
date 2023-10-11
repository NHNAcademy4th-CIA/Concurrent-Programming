package org.nhnacademy.leejungbum.runnable.runnable1;

import org.nhnacademy.leejungbum.counter.counter2.Counter;

public class TestCounter {
    public static void main(String[] args) {
        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable");
        Thread thread = new Thread(counterRunnable);

        thread.start();
    }
}