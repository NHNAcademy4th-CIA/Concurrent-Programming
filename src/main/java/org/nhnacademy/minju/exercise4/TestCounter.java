package org.nhnacademy.minju.exercise4;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numberOfIterations = 100_000000;

        long start = System.nanoTime();

        CountAgent agent1 = new CountAgent(counter, numberOfIterations, true);
        CountAgent agent2 = new CountAgent(counter, numberOfIterations, false);

        agent1.start();
        agent2.start();

        try {
            agent1.join();
            agent2.join();
        } catch (InterruptedException ignore) {
        }
        long end = System.nanoTime();
        System.out.println("Count : " + counter.getCount());
        System.out.println("Another Count : " + counter.getAnotherCount());
        System.out.println("실행 시간 : " + (end - start) / 1000000000 + "초");
    }
}
