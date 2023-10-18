package org.nhnacademy.leejungbum.runnable.runnable1;

public class CounterRunnable implements Runnable  {
    private String name;
    private int count;

    public CounterRunnable(String name) {
        this.name=name;
        this.count=0;
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