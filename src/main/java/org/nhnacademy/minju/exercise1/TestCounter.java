package org.nhnacademy.minju.exercise1;

public class TestCounter {
    public static void main(String[] args) {
        CounterThread counterThread1 = new CounterThread("CounterThread1");
        CounterThread counterThread2 = new CounterThread("CounterThread2");

        counterThread1.start();
        counterThread2.start();
    }
}
