package org.nhnacademy.lsj.section3;

// data 받을 class
public class Receiver implements Runnable, Wait {

    private final Pipe pipe;

    private int endData;

    public Receiver(Pipe pipe, int endData) {
        this.pipe = pipe;
        this.endData=endData;
    }

    @Override
    public void run() {

        int data;
        do {
            data = pipe.receive();
            waitThread();
        } while (data != this.endData);


        System.out.println(data+ " 리시브 끝");



    }
}
