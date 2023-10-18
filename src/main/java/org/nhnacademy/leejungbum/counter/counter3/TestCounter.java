package org.nhnacademy.leejungbum.counter.counter3;

public class TestCounter {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread("CounterThread");

        counterThread.start();
    }
}

