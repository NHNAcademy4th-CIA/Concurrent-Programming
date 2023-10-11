package org.nhnacademy.leejungbum.counter;

public class Counter {
    private String name;
    private int count;
    public Counter(){
        name="Counter";
        count=0;
    }

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
