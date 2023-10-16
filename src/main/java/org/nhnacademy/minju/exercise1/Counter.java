package org.nhnacademy.minju.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {
    private static final Logger logger = LoggerFactory.getLogger(Counter.class);
    private final String name;
    private int count;

    public Counter(String name) {
        this.name = name;
        this.count = 0;
    }

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
