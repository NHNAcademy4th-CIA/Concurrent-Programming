package org.nhnacademy.lsj.section3;

public class Sender implements Runnable, Wait {

    private final Pipe pipe;

    public Sender(Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run() { // data 를 보낼꺼임


        int data = -1;
        while (true){
            data++;
            pipe.send(data);
            waitThread();
        }

    }


}
