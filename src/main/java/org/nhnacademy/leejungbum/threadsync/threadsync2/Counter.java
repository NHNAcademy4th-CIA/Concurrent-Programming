package org.nhnacademy.leejungbum.threadsync.threadsync2;

public class Counter {
    private long count =0;

    private long anotherCount =0;
    public synchronized void increment() {
      	count++;
    }


    public synchronized void decrement() {
      	count--;
    }



    public synchronized long getCount() {
      	return count;
    }

    public long getAnotherCount() {
        return anotherCount;
    }

    public void anotherIncrement() {
        anotherCount++;
    }
    public void anotherDecrement() {
        anotherCount++;
    }
}