package org.nhnacademy.lsj.section4;

public class Counter {


    private long number;


    public synchronized void increasement(){
        this.number++;
    }

    public synchronized void decreasement(){
        this.number--;

    }
    public long getCounter(){
        return this.number;
    }

}
