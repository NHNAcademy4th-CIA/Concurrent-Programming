package org.nhnacademy.lsj.section3;

public class Pipe implements Wait {


    private int data;

    private boolean empty = true;

    public synchronized int receive() {

        System.out.println("리시브 시작");

        while (empty) { // receiver 한테 data 주기
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        waitThread();


        empty = true; // 데이터 보낼꺼야


        System.out.println(data+ "  리시브 끝");

        notifyAll();
        return data;  // 데이터 보내기
    }

    public synchronized void send(int data) { // sender 한테서 data 받기
        System.out.println("샌드 시작");

        while (!empty) { // 보낼 data 있으면 대기

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }


        waitThread();

        this.data = data; // data 받았음
        this.empty = false; // 비어있지 않음


        System.out.println(data + " 샌드 끝");
        notifyAll();


    }

}
