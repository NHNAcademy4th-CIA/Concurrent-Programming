package org.nhnacademy.minju.exercise7;

/**
 * 데몬 스레드는 백그라운드에서 동작하는 스레드로, 일반 스레드가 종료될 때 자동으로 종료된다.
 */
public class TestDaemonThread {
    public static class WorkerThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getName() + " is Daemon : " + this.isDaemon());
            super.run();
        }
    }

    public static void main(String[] args) {
        WorkerThread workerThread1 = new WorkerThread();
        WorkerThread workerThread2 = new WorkerThread();
        workerThread2.setDaemon(true);

        workerThread1.start();
        workerThread2.start();

        workerThread1.interrupt();

        System.out.println("Main Thread terminated");
    }
}
