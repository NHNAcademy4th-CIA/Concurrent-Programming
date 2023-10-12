package org.nhnacademy.minju.exercise4;

public class Counter {
    long count;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public long getCount() {
        return count;
    }
}
