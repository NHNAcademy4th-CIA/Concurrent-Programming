package org.nhnacademy.leejungbum.runnable.runnable2;

import org.nhnacademy.leejungbum.runnable.runnable1.CounterRunnable;

public class TestCounter {
    public static void main(String[] args) {
        CounterRunnable counterRunnable1 = new CounterRunnable("CounterRunnable1");
        CounterRunnable counterRunnable2 = new CounterRunnable("CounterRunnable2");

        Thread thread1 = new Thread(counterRunnable1);
        Thread thread2 = new Thread(counterRunnable2);
//        counterRunnable1.run();
        thread1.start();
        thread2.start();
    }
}
