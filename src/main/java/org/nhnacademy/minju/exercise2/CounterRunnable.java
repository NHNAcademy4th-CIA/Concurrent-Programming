package org.nhnacademy.minju.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterRunnable implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(CounterRunnable.class);
    private String name;
    private int count;

    public CounterRunnable(String name) {
        this.name = name;
        this.count = 0;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            logger.info("{} : {}", name, ++count);
        }
    }
}
