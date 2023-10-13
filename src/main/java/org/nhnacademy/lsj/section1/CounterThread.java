package org.nhnacademy.lsj.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(CounterThread.class);

    private String name;
    private int count;

    public CounterThread(String name) {
        this.name = name;
        this.count = 0;
    }

    private void increaseCount() {
        this.count++;
    }

    public void run() {

        while (!Thread.interrupted()) {
            increaseCount();
            try {
                Thread.sleep(1000);
                logger.info("{} : {}", this.name, this.count);
            } catch (InterruptedException e) {
                logger.warn("{}", e.getMessage());
            }
        }

    }

}