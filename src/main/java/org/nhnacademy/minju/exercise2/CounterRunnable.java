package org.nhnacademy.minju.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(CounterRunnable.class);
    private Thread thread;
    private String name;
    private int count;

    public CounterRunnable(String name) {
        this.name = name;
        this.count = 0;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                ++count;
                System.out.println(name + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
