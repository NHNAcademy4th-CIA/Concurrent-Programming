package org.nhnacademy.lsj.section3;

/**
 * 두 스레드간 데이터를 전송할 Pipe 클래스.
 * 두 스레드는 Pipe를 통해서 연결된다.
 * Pipe에 비워져 있으면 데이터는 즉시 전송되고, 그렇지 않은 경우 이전 데이터가 전송될 때까지 기다린다.
 * Sender는 임의의 시간 간격으로 데이터를 Pipe에 밀어 넣는다.
 * 파이프 채워져 있는 경우, 대기 상태를 유지한다.
 * Receiver는 Pipe에서 전송되는 데이터를 받는다.
 * 파이프에 데이터가 없는 경우, 기다린다.
 */
public class Pipe implements Wait {


    private int data;

    private boolean empty = true;

    /**
     * pipe 가 data를 receiver 한테 보낸다.
     *
     * @return receiver 에게 보낼 data.
     */
    public synchronized int send() {

        System.out.println("리시브 시작");

        while (empty) { // 파이프 비어있으면 대기해
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        waitThread();


        empty = true; // 데이터 보낼꺼라 이제 비어있는 상태.


        System.out.println(data + "  리시브 끝");

        notifyAll();
        return data;  // 데이터 보내기
    }

    /**
     * pipe가 sender 한테서 data 받음.
     *
     * @param data pipe가 받을 data.
     */
    public synchronized void receive(int data) { // sender 한테서 data 받기
        System.out.println("샌드 시작");

        while (!empty) { // pipe가 차있으면 대기.

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
