package org.nhnacademy.leejungbum.threadstatus;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Pipe pipe;
    private int endData;
    public Receiver(Pipe pipe, int endData) {
        this.pipe = pipe;
        this.endData=endData;
    }

    public void run() {
        for (int receivedMessage = pipe.receive(); 9!=(receivedMessage); receivedMessage = pipe
                .receive()) {

            System.out.println(receivedMessage);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
