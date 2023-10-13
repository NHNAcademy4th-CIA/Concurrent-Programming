package org.nhnacademy.leejungbum.threadsync.threadsync1;

public class Counter {
    private long count =0;
    public void increment() {
      	count++;
    }


    public void decrement() {
      	count--;
    }


    public	long getCount() {
      	return count;
    }
}