package org.nhnacademy.minju.exercise4;

public class Counter {
    int count;
    int anotherCount;

    public synchronized void increment() {
        count++;
    }

    public void increment2() {
        anotherCount++;
    }

    public synchronized void decrement() {
        count--;
    }

    public void decrement2() {
        anotherCount--;
    }

    public long getCount() {
        return count;
    }

    public int getAnotherCount() {
        return anotherCount;
    }
}
