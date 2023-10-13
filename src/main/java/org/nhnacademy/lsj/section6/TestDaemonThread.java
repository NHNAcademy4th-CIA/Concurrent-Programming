package org.nhnacademy.lsj.section6;

public class TestDaemonThread {


    public static class DaemonThread extends Thread {
        @Override
        public void run() {

            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("종료됩니다.");
                }
                System.out.println("1초에 한번 씩 출력 합니다 Daemon.");

            }

        }
    }


    public static class WorkerThread extends Thread {
        @Override
        public void run() {

            DaemonThread daemonThread = new DaemonThread();
            daemonThread.setDaemon(true);

            daemonThread.start();

            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    System.out.println("안녕");
                    Thread.currentThread().interrupt();
                }

                System.out.println("1초에 한번 씩 출력 합니다. Main");

            }

        }
    }

    public static void main(String[] args) {

        WorkerThread workerThread = new WorkerThread();

        workerThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        workerThread.interrupt();

        System.out.println("Main Thread terminated");

        // Daemon 은 main이 끝나니 알아서 종료.

    }


}
