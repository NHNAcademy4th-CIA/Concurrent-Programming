package org.nhnacademy.minju.exercise3;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    final Pipe pipe;

    public Sender(Pipe pipe) {
        this.pipe = pipe;
    }

    /**
     * pipe를 통해 데이터를 전송
     * 전송에 성공하면 일정시간 기다린다
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                pipe.send(i);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
