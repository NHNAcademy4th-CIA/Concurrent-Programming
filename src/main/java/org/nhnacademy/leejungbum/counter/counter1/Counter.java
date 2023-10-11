package org.nhnacademy.leejungbum.counter.counter1;

public class Counter {

    private String name;
    private int count;
    public Counter(){
        name="counter";
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
            System.out.println(getClass().getSimpleName()+ " : "+count);
        }
    }
}
