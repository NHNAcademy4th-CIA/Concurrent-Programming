package org.nhnacademy.minju.exercise2;

public class TestCounter {
    public static void main(String[] args) {
        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable");
        Thread thread = new Thread(counterRunnable);

        thread.start();
    }
}
