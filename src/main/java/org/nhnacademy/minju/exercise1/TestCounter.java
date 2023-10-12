package org.nhnacademy.minju.exercise1;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter("Counter");
        CounterThread counterThread = new CounterThread("CounterThread");

        counterThread.start();
        counter.run();
    }
}
