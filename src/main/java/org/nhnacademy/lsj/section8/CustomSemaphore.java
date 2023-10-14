package org.nhnacademy.lsj.section8;

public class CustomSemaphore {

    private int count;

    public CustomSemaphore(int count) {
        this.count = count;
    }

    public synchronized void acquire() throws InterruptedException {

        while (count == 0) {
            wait();
        }
        count--;
    }

    public synchronized void release() {
        count++;
        notify();
    }


}
