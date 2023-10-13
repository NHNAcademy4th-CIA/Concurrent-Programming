package org.nhnacademy.leejungbum.threadsync.threadsync1;

public class TestCounter {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();
        Counter counter = new Counter();
        int numberOfIterations = 10000;

        CountAgent agent1 = new CountAgent(counter, numberOfIterations, true);
        CountAgent agent2 = new CountAgent(counter, numberOfIterations, false);

        agent1.start();
        agent2.start();

        try {
            agent1.join();
            agent2.join();
        } catch(InterruptedException ignore) {
        }
        System.out.println("Count : " + counter.getCount());
        long end =System.currentTimeMillis();
        System.out.println("실행시간 : "+ (end-start)+"초");

    }
}