package org.nhnacademy.minju.exercise2;

public class TestCounter {
    public static void main(String[] args) {
        CounterRunnable counterRunnable1 = new CounterRunnable("CounterRunnable1");
        Thread thread1 = new Thread(counterRunnable1);
        CounterRunnable counterRunnable2 = new CounterRunnable("CounterRunnable2");
        Thread thread2 = new Thread(counterRunnable2);

        thread1.start();
        thread2.start();
    }
}
