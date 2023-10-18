package org.nhnacademy.leejungbum.threadstatus;

import java.util.Timer;

public class Pipe {
    private int data;

    // True if receiver should wait
    // False if sender should wait
    private boolean empty = true;

    public synchronized int receive() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        empty = true;
        notify();
        return data;
    }

    public synchronized void send(int data) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        empty = false;

        this.data = data;
        notify();
    }
}
