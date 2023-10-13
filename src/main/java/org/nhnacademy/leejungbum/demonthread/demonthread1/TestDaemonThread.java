package org.nhnacademy.leejungbum.demonthread.demonthread1;

public class TestDaemonThread {
    public static class WorkerThread extends Thread {
        public WorkerThread(String name){
            super(name);
        }
        @Override
        public void run(){
            while (!Thread.interrupted()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(getName()+" " +getState());
            }
        }
    }

    public static void main(String[] args) {
        WorkerThread w1 = new WorkerThread("thread1");
        WorkerThread w2 = new WorkerThread("demon");

        w1.setDaemon(true);
        w1.start();
        w2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        w1.interrupt();
        System.out.println("Main Thread terminated");
    }
}
