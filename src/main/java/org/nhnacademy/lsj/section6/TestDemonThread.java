package org.nhnacademy.lsj.section6;

public class TestDemonThread {

    public static class WorkerThread extends Thread {

        @Override
        public void run() {

            while (!Thread.interrupted()){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                    break;
                }
                System.out.println("1초에 한번 씩 출력 합니다.");

            }

        }
    }

    public static void main(String[] args) {


        WorkerThread workerThread = new WorkerThread();

        WorkerThread daemonThread = new WorkerThread();

        workerThread.start();
        daemonThread.setDaemon(true);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        workerThread.interrupt();

        System.out.println("Main Thread terminated");

        // 데몬 스레드는 일반 스레드가 종료되면 그대로 종료

    }

}
