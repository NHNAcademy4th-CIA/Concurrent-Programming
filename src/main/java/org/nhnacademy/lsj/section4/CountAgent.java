package org.nhnacademy.lsj.section4;

/**
 * Counter 클래스 인스턴스를 사용할 CountAgent 클래스, Thread 를 extends받아 사용.
 */
public class CountAgent extends Thread {
    final Counter counter;
    int numberOfIterations;
    boolean increment;

    /**
     * 생성자.
     *
     * @param counter            사용할 counter class.
     * @param numberOfIterations 증감시킬 횟수.
     * @param increment          true면 ++ , false면 --.
     */
    public CountAgent(Counter counter, int numberOfIterations, boolean increment) {
        super();
        this.counter = counter;
        this.numberOfIterations = numberOfIterations;
        this.increment = increment;
    }

    /**
     * 증감 진행.
     */
    @Override
    public void run() {
        for (int i = 0; i < numberOfIterations; i++) {
            if (increment) {
                counter.increasement();
                counter.increasementAnother();
            } else {
                counter.decreasement();
                counter.decreasementAnother();
            }
        }
    }
}