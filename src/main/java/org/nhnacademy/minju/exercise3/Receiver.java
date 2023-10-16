package org.nhnacademy.minju.exercise3;

import java.time.LocalDateTime;

public class Receiver implements Runnable {
    final Pipe pipe;
    int endData;

    public Receiver(Pipe pipe, int endData) {
        this.pipe = pipe;
        this.endData = endData;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            int data = pipe.receive();
            if (data == endData) {
                Thread.currentThread().interrupt();
            }
            try {
                System.out.println("[ " + LocalDateTime.now() + " ] Data : " + data);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
