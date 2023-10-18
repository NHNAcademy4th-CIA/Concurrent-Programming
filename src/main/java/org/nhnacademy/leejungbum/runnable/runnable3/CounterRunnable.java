package org.nhnacademy.leejungbum.runnable.runnable3;

public class CounterRunnable implements Runnable  {
    private Thread thread;
    private String name;
    private int count;

    public CounterRunnable(String name) {
        this.name=name;
        this.count=0;
        thread= new Thread(this);
    }
    public void start(){
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println(name+" : "+count);
        }
    }
}