package org.nhnacademy.leejungbum.counter.counter4;

public class CounterThread extends Thread {

    private String name;
    private int count;
    public CounterThread(String name){
        this.name=name;
        count=0;
    }

    @Override
    public void run(){
        while (!Thread.interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println(name+ " : "+count);
        }
    }
}
