package org.nhnacademy.leejungbum.threadstatus;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Pipe pipe;

    public Sender(Pipe pipe) {
        this.pipe = pipe;
    }
    public void run() {
        int data =1;

        while (data<=9) {
            pipe.send(data++);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}