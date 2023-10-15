package org.nhnacademy.minju.exercise7;

/**
 * 데몬 스레드는 백그라운드에서 동작하는 스레드로, 일반 스레드가 종료될 때 자동으로 종료된다.
 */
public class TestDaemonThread {
    public static class DaemonThread extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    System.out.println("daemon thread");
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("daemon thread terminated");
                    Thread.currentThread().interrupt();

                }
            }
        }
    }

    public static class WorkerThread extends Thread {
        DaemonThread daemonThread;

        WorkerThread() {
            daemonThread = new DaemonThread();
            daemonThread.setDaemon(true);
        }

        @Override
        public void run() {
            daemonThread.start();
            while (!Thread.interrupted()) {
                try {
                    System.out.println("workThread");
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("WorkThread Terminated");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        WorkerThread workerThread = new WorkerThread();

        workerThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        workerThread.interrupt();

        System.out.println("Main Thread terminated");
    }
}
