package org.nhnacademy.leejungbum.demonthread.demonthread2;

public class TestDaemonThread {
    public static class DaemonThread extends Thread {
        public DaemonThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    interrupt();
                    System.out.println("데몬 스레드 종료");
                }
                System.out.println(getName() + " " + getState());
            }
        }
    }

    public static class WorkerThread extends Thread {

        DaemonThread d;
        public WorkerThread(String name) {
            super(name);
            this.d = new DaemonThread("demon");
            d.setDaemon(true);
        }

        @Override
        public void run() {
            d.start();
            while (!Thread.interrupted()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    interrupt();
                    System.out.println("메인 스레드 종료");
                }
                System.out.println(getName() + " " + getState());
            }
        }
    }

    public static void main(String[] args) {
        WorkerThread w1 = new WorkerThread("thread1");

        w1.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        w1.interrupt();
        System.out.println("Main Thread terminated");
    }
}
