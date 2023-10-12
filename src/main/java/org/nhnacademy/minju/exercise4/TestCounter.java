package org.nhnacademy.minju.exercise4;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numberOfIterations = 10000;

        CountAgent agent1 = new CountAgent(counter, numberOfIterations, true);
        CountAgent agent2 = new CountAgent(counter, numberOfIterations, false);

        agent1.start();
        agent2.start();

        try {
            agent1.join();
            agent2.join();
        } catch (InterruptedException ignore) {
        }

        System.out.println("Count : " + counter.getCount());
        System.out.println("Another Count : " + counter.getAnotherCount());

    }
}
