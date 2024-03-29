package org.nhnacademy.minju.exercise4;

public class CountAgent extends Thread{
    final Counter counter;
    int numberOfIterations;
    boolean increment;

    public CountAgent(Counter counter, int numberOfIterations, boolean increment) {
        super();
        this.counter = counter;
        this.numberOfIterations = numberOfIterations;
        this.increment = increment;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < numberOfIterations; i++) {
            if (increment) {
                counter.increment();
                counter.increment2();
            } else {
                counter.decrement();
                counter.decrement2();
            }
        }
    }
}