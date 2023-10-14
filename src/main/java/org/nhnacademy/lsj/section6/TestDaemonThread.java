package org.nhnacademy.lsj.section6;

/**
 * 데몬 스레드
 * Java에서의 스레드는 일반 스레드(User Thread)와 데몬 스레드(Daemon Thread)로 나뉜다.
 * 일반 스레드는 특별히 데몬 스레드로 설정하지 않은 스레드로서 일반적으로 생성해서 사용되는 스레드이다.
 * JVM은 모든 일반 스레드가 종료될 때까지 프로그램을 실행한다.
 * 데몬 스레드는 백그라운드에서 동작하는 스레드로, 일반 스레드가 종료될 때 자동으로 종료된다.
 * 주로 메인 스레드나 다른 일반 스레드의 보조 역할을 수행하거나, 특정 작업을 주기적으로 처리하는 스레드 등에 사용된다.
 * JVM은 모든 일반 스레드가 종료되면 데몬 스레드를 강제로 종료합니다.
 */
public class TestDaemonThread {


    /**
     * 1초에 한번씩 출력하는 Daemon Thread.
     */
    public static class DaemonThread extends Thread {
        @Override
        public void run() {

            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("1초에 한번 씩 출력 합니다 Daemon.");

            }

        }
    }


    /**
     * 1초에 한번씩 출력하는 일반 Thread , 내부에서 daemon thread를 부름.
     */
    public static class WorkerThread extends Thread {
        @Override
        public void run() {

            DaemonThread daemonThread = new DaemonThread();
            daemonThread.setDaemon(true); // daemon이 아니면 main끝나도 계속 출력됨.

            daemonThread.start();

            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("1초에 한번 씩 출력 합니다. Main");

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    Thread.currentThread().interrupt();
                }

            }

        }
    }

    /**
     * 연습 7. 일반 스레드와 데몬 스레드를 생성한다. 단, 데몬 스레드는 일반 스레드 안에서 실행하도록 수정한 후 실행 종료 후 각 스레드의 상태를 확인 하자
     *
     * @param args command line.
     */
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

        // Daemon 은 main이 끝나니 알아서 종료됨 .
        // 일반 Thread의 경우 main과 상관없이 계속 실행됨.

    }


}
