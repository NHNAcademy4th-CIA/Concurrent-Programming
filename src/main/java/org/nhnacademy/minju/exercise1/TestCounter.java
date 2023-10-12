package org.nhnacademy.minju.exercise1;

public class TestCounter {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread("CounterThread");
        counterThread.start();
    }
}
