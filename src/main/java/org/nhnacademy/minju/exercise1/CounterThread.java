package org.nhnacademy.minju.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterThread extends Thread {
    private String name;
    private int count;
    private static final Logger logger = LoggerFactory.getLogger(CounterThread.class);

    public CounterThread(String name) {
        this.name = name;
        this.count = 0;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            logger.info("{} : {}", name, ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
