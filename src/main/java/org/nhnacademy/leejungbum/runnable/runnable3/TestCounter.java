package org.nhnacademy.leejungbum.runnable.runnable3;

public class TestCounter {
    public static void main(String[] args) {
        CounterRunnable counterRunnable1 = new CounterRunnable("CounterRunnable1");
        CounterRunnable counterRunnable2 = new CounterRunnable("CounterRunnable2");

        counterRunnable1.start();
        counterRunnable2.start();

    }
}