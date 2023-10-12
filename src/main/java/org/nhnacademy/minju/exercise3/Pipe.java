package org.nhnacademy.minju.exercise3;

public class Pipe {
    private int data;
    private boolean empty;

    public Pipe() {
        this.data = 0;
        this.empty = true;
    }

    public synchronized int receive() throws InterruptedException {
        while (empty) {
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        empty = true;
        notify();
        return data;
    }

    public synchronized void send(int data) throws InterruptedException {
        while (!empty) {
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.data = data;
        this.empty = false;
        notify();
    }
}
